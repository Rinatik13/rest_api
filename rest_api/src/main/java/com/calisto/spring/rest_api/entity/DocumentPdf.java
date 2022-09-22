package com.calisto.spring.rest_api.entity;

import com.calisto.spring.rest_api.enums.DocumentBlock;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;

import javax.persistence.*;
import java.net.MalformedURLException;

@Entity
public class DocumentPdf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Transient
    private String body;

//    @Enumerated
//    private DocumentBlock block;
    private String address;

    public DocumentPdf() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Image giveImage (float fitWidth, float fitHeight){
        Image result = null;
        ImageData imageData = null;
        try {
            imageData = ImageDataFactory.create(address);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
