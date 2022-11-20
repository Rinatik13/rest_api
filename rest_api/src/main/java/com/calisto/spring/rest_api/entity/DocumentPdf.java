package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class DocumentPdf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Не указано название файла.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер названия файла.")
    private String name;

    @Transient
    private String body;

    @NotEmpty(message = "Не указан адрес файла.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер названия адреса файла.")
    private String address;

    // id company
    private int company_id;
    // block
    private String block;
    // id block
    private int block_id;

    public DocumentPdf() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public Image giveImage (float fitWidth, float fitHeight){
//        Image result = null;
//        ImageData imageData = null;
//        try {
//            imageData = ImageDataFactory.create(address);
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        result = new Image(imageData);
//        result.scaleAbsolute(fitWidth,fitHeight);
//        return result;
//    }

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

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
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
}
