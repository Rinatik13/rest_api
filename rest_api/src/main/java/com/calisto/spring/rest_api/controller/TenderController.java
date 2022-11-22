package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.service.tender.TenderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/calisto/tender")
public class TenderController {
    private static final Logger log = Logger.getLogger(TenderController.class);
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
    public Link getDownloadDocument(@PathVariable int id) throws IOException {
        log.info("Начинаем подготовку документов");
        return tenderService.getLink(id);
    }
}
