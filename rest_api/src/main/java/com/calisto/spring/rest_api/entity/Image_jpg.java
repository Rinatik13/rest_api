package com.calisto.spring.rest_api.entity;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.net.MalformedURLException;

@Entity
public class Image_jpg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Transient
    private String body;
    private String block;
    private int block_id;
    private int company_id;
    private String address;

    public Image_jpg() {
    }

    public Image giveImage (float fitWidth, float fitHeight){
        Image result = null;
        ImageData imageData = null;
        try {
            // берёт адрес не оттудово откуда надо
            // надо реализовать функцию, которая получает адрес файла по методу запроса документов в
            // яндекс диске
            // погнали
            ControllerCommunication communication = new ControllerCommunication();
            String url = communication.getDownFile(address + "/" + name + ".jpg").getHref();
            imageData = ImageDataFactory.create(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        result = new Image(imageData);
        result.scaleAbsolute(fitWidth,fitHeight);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getBlock_id() {
        return block_id;
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
