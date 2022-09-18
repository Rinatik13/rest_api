package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddNewFolderTest extends AddNewFolder {

    @Test
    public void testAddFolder() {
        Link res = new Link();
        res = addFolder("user_1");
        System.out.println(res);
    }
}