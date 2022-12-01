package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.util.*;
// реализуем управление работы с Yandex Api диском

public class ControllerCommunication{
    private static final Logger log = Logger.getLogger(ControllerCommunication.class);
    String URLApi = "https://cloud-api.yandex.net/v1/disk/resources?path=";
    String URLApiDown = "https://cloud-api.yandex.net/v1/disk/resources/download?path=";
    String URLApiUpload = "https://cloud-api.yandex.net/v1/disk/resources/upload?path=";
    String auth = "Authorization";
    String OAuth = "AQAAAAAPGEiVAADLW-o0sA3bOkg9j-CFcK4lxJA";
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<>(headers);
    // метод удаляет папку или файл, или всё сразу
    public String delete(String address) {
        headers.add(auth, OAuth);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URLApi + address, HttpMethod.DELETE, request, new ParameterizedTypeReference<String>() {
        });
//        log.info("удаляем файл по адресу: " + address);
        return responseEntity.getBody();
    }

    // метод создаёт папки. надо ещё протестировать более изошрённо
    // получает адрес файла и запихивает его в массив и далее работает с массивом
    public List<Link> createFolder(String addressFolrder, String addressPath) {
        headers.add(auth, OAuth);
        headers.add("Accept","application/json");
        List<Link> links = new ArrayList<>();
        String myUrl = URLApi;
        if (addressPath == null) {
            String[] nameList = addressFolrder.split("/");
            for (String s : nameList) {
                myUrl = myUrl + s + "/";
                ResponseEntity<Link> responseEntity = restTemplate
                        .exchange(myUrl, HttpMethod.PUT, request, new ParameterizedTypeReference<Link>() {
                });
                links.add(responseEntity.getBody());
            }
            myUrl = URLApi;
//            log.info("создаём папки: " + addressFolrder);
            return links;
        }
        else{
            myUrl+= addressPath + "/";
                ResponseEntity<Link> responseEntity = restTemplate
                        .exchange(myUrl + addressFolrder, HttpMethod.PUT, request, new ParameterizedTypeReference<Link>() {
                });
                links.add(responseEntity.getBody());
            myUrl = URLApi;
//            log.info("создаём папки: " + addressFolrder);
            return links;
        }
    }
    // метод получает Link, данный класс JSON объект ответа яндекс диска
    // в нём содержится данные для скачивания файла
    public Link getDownFile(String address) {
        headers.add(auth, OAuth);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<Link> responseEntity =
                restTemplate.exchange(URLApiDown + address, HttpMethod.GET, request, new ParameterizedTypeReference<Link>() {
                });
//        log.info("получаем ссылку для скачивания файла: " + address);
        return responseEntity.getBody();
    }
    // реализуем метод по получению Link, данный класс JSON объекта ответа яндекс диска
    // в нём содержится данные для закачивания файла
    public Link getUploadFile(String address) {
        headers.add(auth, OAuth);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<Link> responseEntity =
                restTemplate.exchange(URLApiUpload + address, HttpMethod.GET, request, new ParameterizedTypeReference<Link>() {
                });
//        log.info("получаем ссылку для скачивания файла: " + address);
        return responseEntity.getBody();
    }
    public  HttpURLConnection getHttpConnection(String url, String type){
//        log.info("запускаем метод getHttpConnection для работы с link: " + url);
        URL uri = null;
        HttpURLConnection connect = null;
        try{
            uri = new URL(url);
            connect = (HttpURLConnection) uri.openConnection();
            connect.setRequestMethod(type); //type: POST, PUT, DELETE, GET
            connect.setDoOutput(true);
            connect.setDoInput(true);
            connect.setConnectTimeout(950000); //950 secs
            connect.setReadTimeout(950000); //950 secs
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        log.info("завершаем выполнение метод getHttpConnection для работы с link: " + url);
        return connect;
    }
    // метод позволяет отправить файлы на сервер по открытому url адресу
    // указываем тим PUT, POST, DELETE, GET
    // после указываем адрес где хранится заветный файл
    public void uploadFile(String url, String type, String reqbody){
//        log.info("загружаем файл по адресу: " + url);
        HttpURLConnection con = null;
        try {
            con = getHttpConnection(url , type);
            if( reqbody != null){
                DataOutputStream out = new DataOutputStream(con.getOutputStream());
                out.writeBytes(reqbody);
                out.close();
            }
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            in.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public synchronized void uploadFileByte(String url, String type, byte[] reqbody){
        HttpURLConnection con = null;
        try {
            con = getHttpConnection(url , type);
            if( reqbody != null){
                DataOutputStream out = new DataOutputStream(con.getOutputStream());
                out.write(reqbody);
                out.close();
            }
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            in.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // пытаемся написать метод для работы с запросами используя Httpclient
    public void uploadFileByteApachHttpClient(String url, String type, byte[] reqbody){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpUriRequest httpPut = new HttpPut(url);
        try(CloseableHttpResponse httpClientPut = httpClient.execute(httpPut)){
            org.apache.hc.core5.http.HttpEntity entity = httpClientPut.getEntity();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
