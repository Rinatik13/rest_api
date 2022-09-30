package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.GetUpLink;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class CopyDocumentTest extends CopyDocument {

    @Test
    public void testCopyDoc() {
        try {
            GetUpLink api = new GetUpLink();
            Link link = api.getUrlUpFile();
            URL url = new URL(link.getHref());
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            Files.copy(inputStream,new File("C:\\java\\test\\999.pdf").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}