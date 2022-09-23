package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
// реализуем управление работы с Yandex Api диском

public class ControllerCommunication {
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

        ResponseEntity<String> responseEntity = restTemplate.exchange(URLApi + address, HttpMethod.DELETE, request, new ParameterizedTypeReference<String>() {
        });
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
                System.out.println("Добавляем: " + s);
                ResponseEntity<Link> responseEntity = restTemplate
                        .exchange(myUrl, HttpMethod.PUT, request, new ParameterizedTypeReference<Link>() {
                });
                links.add(responseEntity.getBody());
            }
            myUrl = URLApi;
            return links;
        }
        else{
            myUrl+= addressPath + "/";
            System.out.println("Добавляем: " +  addressFolrder);
                ResponseEntity<Link> responseEntity = restTemplate
                        .exchange(myUrl + addressFolrder, HttpMethod.PUT, request, new ParameterizedTypeReference<Link>() {
                });
                links.add(responseEntity.getBody());
            myUrl = URLApi;
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
        return responseEntity.getBody();
    }

    public  HttpURLConnection getHttpConnection(String url, String type){
        URL uri = null;
        HttpURLConnection con = null;
        try{
            uri = new URL(url);
            con = (HttpURLConnection) uri.openConnection();
            con.setRequestMethod(type); //type: POST, PUT, DELETE, GET
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setConnectTimeout(60000); //60 secs
            con.setReadTimeout(60000); //60 secs

        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return con;
    }

    // метод позволяет отправить файлы на сервер по открытому url адресу
    // указываем тим PUT, POST, DELETE, GET
    // после указываем адрес где хранится заветный файл
    public void uploadFile(String url, String type, String reqbody){
        System.out.println(reqbody);
        HttpURLConnection con = null;
        String result = null;
        try {
            con = getHttpConnection( url , type);
            if( reqbody != null){
                con.setDoInput(true);
                con.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(con.getOutputStream());

//                byte[] buffer = Files.readAllBytes(Paths.get(reqbody));
                out.writeBytes(reqbody);
                out.close();
            }
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String temp = null;
            StringBuilder sb = new StringBuilder();
            while((temp = in.readLine()) != null){
                sb.append(temp).append(" ");
            }
            result = sb.toString();
            in.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void uploadFileByte(String url, String type, byte[] reqbody){
        System.out.println(reqbody);
        HttpURLConnection con = null;
        String result = null;
        try {
            con = getHttpConnection( url , type);
            if( reqbody != null){
                con.setDoInput(true);
                con.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(con.getOutputStream());

//                byte[] buffer = Files.readAllBytes(Paths.get(reqbody));
                out.write(reqbody);
                out.close();
            }
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String temp = null;
            StringBuilder sb = new StringBuilder();
            while((temp = in.readLine()) != null){
                sb.append(temp).append(" ");
            }
            result = sb.toString();
            in.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
