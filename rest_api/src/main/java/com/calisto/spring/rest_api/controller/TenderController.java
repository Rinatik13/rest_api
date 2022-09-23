package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.service.tender.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/tender")
public class TenderController {
    @Autowired
    TenderService tenderService;

    @GetMapping("/all")
    public List<Tender> getAllTender(){
        return tenderService.getAll();
    }

    @PostMapping("/add")
    public Tender addTender(@RequestBody Tender tender){
        return tenderService.add(tender);
    }

    @GetMapping("/get/{id}")
    public Tender getTender(@PathVariable int id){
        return tenderService.getTender(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        tenderService.delete(id);
        return "Удалено!";
    }

    @GetMapping("/build/{id}")
    public Link getDownloadDocument(@PathVariable int id){
        ControllerCommunication communication = new ControllerCommunication();
        Link url = communication.getDownFile("1234.zip");
        return url;
    }
}
