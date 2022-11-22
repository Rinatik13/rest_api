package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.itextpdf.io.source.ByteArrayOutputStream;

public interface GeneratorDoc {

    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ);
    public String getNameFile();
    public String getPath();

}
