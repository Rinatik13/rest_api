package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.apache.tomcat.util.buf.Utf8Encoder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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

    // метод удаляет папку или файл, или всё сразу
    public String delete(String address) {
        headers.add(auth, OAuth);
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URLApi + address, HttpMethod.DELETE, request, new ParameterizedTypeReference<String>() {
        });
        return responseEntity.getBody();
    }

    // метод создаёт папки. надо ещё протестировать более изошрённо
    // получает адрес файла и запихивает его в массив и далее работает с массивом
    public List<Link> createFolder(String address) {
        String[] nameList = address.split("/");
        headers.add(auth, OAuth);
        List<Link> links = new ArrayList<>();
        HttpEntity<String> request = new HttpEntity<>(headers);
        for (String s : nameList) {
            URLApi = URLApi + s + "/";
            ResponseEntity<Link> responseEntity = restTemplate.exchange(URLApi, HttpMethod.PUT, request, new ParameterizedTypeReference<Link>() {
            });
            links.add(responseEntity.getBody());
        }
        return links;
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

    public String uploadFile(String url, String urlMyFile) {
        URL url1 = null;
        try {
            url1 = new URL(url);
            HttpURLConnection httpCon = (HttpURLConnection) url1.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
//            httpCon.setRequestProperty("application","x-www-form-urlencoded");
//            httpCon.setRequestProperty("Content-Type", "form-data");
            httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            DataOutputStream out = new DataOutputStream(httpCon.getOutputStream());


            DataInputStream reader = new DataInputStream(new FileInputStream(urlMyFile));
            BufferedInputStream buf = new BufferedInputStream(reader);
            out.writeBytes(buf.toString());;
            out.flush();
            out.close();
            httpCon.getInputStream();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Загрузилось!";
    }

//        try {

//            URLConnection connection = new URL(url).openConnection();
//            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            connection.setDoOutput(true);
//            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
//            int i;
//            String result = "";
//            while ((i=inputStream.read()) != -1){
//                result+=i;
//            }
//            writer.write(result);
//            inputStream.close();
//            writer.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return "Загрузилось";
//    }

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
//            con.setRequestProperty("Accept-Encoding", "Your Encoding");
//            con.setRequestProperty("Content-Type", "Your Encoding");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return con;
    }

    public void yourmethod(String url, String type, String reqbody){
        HttpURLConnection con = null;
        String result = null;
        try {
            con = getHttpConnection( url , type);
            //you can add any request body here if you want to post
            if( reqbody != null){
                con.setDoInput(true);
                con.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(con.getOutputStream());

                InputStreamReader reader = new InputStreamReader(new FileInputStream(reqbody));
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line;
                String res = "";
                while ((line = bufferedReader.readLine()) != null) {
                    res += line;
                }
                byte[] buffer = res.getBytes();
                out.write(buffer, 0, buffer.length);
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
