package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.Image_jpg;
import com.calisto.spring.rest_api.service.signatureStamp.SignatureStampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/signatureStamp")
public class SignatureStamp {
    @Autowired
    SignatureStampService signatureStampService;

    @GetMapping("/all")
    public List<Image_jpg> getAllSignatureStamp(){
        return signatureStampService.getAll();
    }

    @PostMapping("/add")
    public Image_jpg addSignatureStamp(@RequestBody Image_jpg imageJpg){
        System.out.println("Приняли документ: " + imageJpg.getName() + " / " + imageJpg.getBlock());
        return signatureStampService.add(imageJpg);
    }

    @GetMapping("/get/{id}")
    public Image_jpg getSignatureStamp(@PathVariable int id){
        return signatureStampService.getImageJPG(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        signatureStampService.delete(id);
        return "Удалено!";
    }
}
