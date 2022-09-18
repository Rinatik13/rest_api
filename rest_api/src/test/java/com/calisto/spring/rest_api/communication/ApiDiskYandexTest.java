package com.calisto.spring.rest_api.communication;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.GetUpLink;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.junit.Test;

public class ApiDiskYandexTest extends GetUpLink {

    @Test
    public void testGetUrlUpFile() {
        Link result = getUrlUpFile();
        System.out.println(result);
    }
}