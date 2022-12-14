package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;


public class ControllerCommunicationTest extends ControllerCommunication {

    @Test
    public void testDelete1() {
        System.out.println(delete("test1"));
    }

    @Test
    public void testDeleteFolder(){
        delete("user_1/company_1");
    }

    @Test
    public void testCreateFolder() {
        createFolder("user_1/companys/company_1",null);
    }

    @Test
    public void testGetUplUpFile() {
        try {
            Link result = getDownFile("test/2.bin");
            URL url  = new URL(result.getHref());
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            Files.copy(inputStream,new File("C:\\java\\test\\bin.pdf").toPath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testYourmethod() {
        String url = getUploadFile("user_1/company_0/tenderId_1.zip").getHref();
        String urlMyFile = "C:\\java\\test\\1.zip";

        uploadFile(url,"PUT",urlMyFile);
    }

    @Test
    public void testGetUplUpFile2() {
        try {
            Link result = getDownFile("user_1/company_0/tenderId_1.zip");
            URL url  = new URL(result.getHref());
            System.out.println(url);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }
