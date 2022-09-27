package com.calisto.spring.rest_api.forms.obshie_spravki;

import com.calisto.spring.rest_api.forms.rosneft.GeneratorDoc;

public interface SpravkaDoc extends GeneratorDoc {
    public void setNumDoc(int id);
    public void setNameDoc(String nameDoc);
    public void setBodyDocCompany(String bodyDocCompany);
}
