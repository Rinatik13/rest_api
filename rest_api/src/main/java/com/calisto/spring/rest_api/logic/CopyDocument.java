package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.entity.DocumentPdf;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class CopyDocument {
    public void copyDoc(DocumentPdf doc, String addressFolder){
        String addressFrom = doc.getAddress();
        String name = doc.getName() + doc.getId();
        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(addressFrom);
            os = new FileOutputStream(addressFolder + "\\" + name + ".pdf");
            int data;
            while ((data=is.read()) != -1){
                os.write(data);
            }
            is.close();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
