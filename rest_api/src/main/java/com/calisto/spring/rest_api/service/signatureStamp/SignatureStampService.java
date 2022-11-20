package com.calisto.spring.rest_api.service.signatureStamp;

import com.calisto.spring.rest_api.entity.Image_jpg;

import java.util.List;

public interface SignatureStampService {
    public List<Image_jpg> getAll();
    public Image_jpg add(Image_jpg imageJpg);
    public Image_jpg getImageJPG(int id);
    public void delete(int id);
    public Image_jpg editImageJPG(Image_jpg imageJpg);
}
