package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ControllerCommunicationTest extends ControllerCommunication {

    @Test
    public void testDelete1() {
        System.out.println(delete("test1"));

    }

    @Test
    public void testCreateFolder() {
        createFolder("user_1/companys/company_1");
    }

    @Test
    public void testGetUplUpFile() {
        try {
            Link result = getDownFile("test/1.pdf");
            URL url  = new URL(result.getHref());
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            Files.copy(inputStream,new File("C:\\java\\test\\13.pdf").toPath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testGetUploadFile() {
        String url = getUploadFile("test/2.pdf").getHref();
        String urlMyFile = "C:\\java\\test\\2.pdf";
        System.out.println(uploadFile(url,urlMyFile));


    }

    @Test
    public void testYourmethod() {
        String url = getUploadFile("test/2.pdf").getHref();
        String urlMyFile = "C:\\java\\test\\1.pdf";

        yourmethod(url,"PUT",urlMyFile);
    }

    @Test
    public void testMyMethod(){
        try{
            Link result = getUploadFile("test/2.pdf");
            String urlMyFile = "C:\\java\\test\\1.pdf";
            URL url = new URL(result.getHref());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("PUT");
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            Path sourcePath = Paths.get(urlMyFile);
            Path destinationPath = Paths.get(url.toString());
            Files.copy(sourcePath,destinationPath);
            outputStream.flush();
            outputStream.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}