package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.DocumentPdf;
import com.calisto.spring.rest_api.service.documentpdf.DocumentPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/documentpdf")
public class DocumentPdfController {
    @Autowired
    DocumentPdfService documentPdfService;

    @GetMapping("/all")
    public List<DocumentPdf> getAllDocumentPdf(){
        return documentPdfService.getAll();
    }

    @PostMapping("/add")
    public DocumentPdf addDocumentPdf(@RequestBody DocumentPdf documentPdf){
        System.out.println("Приняли документ: " + documentPdf.getName());
        return documentPdfService.add(documentPdf);
    }

    @GetMapping("/get/{id}")
    public DocumentPdf getDocumentPdf(@PathVariable int id){
        return documentPdfService.getDocumentPdf(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        documentPdfService.delete(id);
        return "Удалено!";
    }
}
