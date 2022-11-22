package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class LoadDocumentToZip {
    public ByteArrayOutputStream getLoadDocument(String address){
        ControllerCommunication communication = new ControllerCommunication();

        Link link = communication.getDownFile(address);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream is = null;
        int data;
            try {
                URL url = new URL(link.getHref());
                URLConnection connection = url.openConnection();
                is = connection.getInputStream();
                while (((data=is.read())!=-1)) {
                    byteArrayOutputStream.write(data);
                }
                is.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        return byteArrayOutputStream;
    }
    }
