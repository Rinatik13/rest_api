package com.calisto.spring.rest_api.service.tender;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.entity.Tender;

import java.io.IOException;
import java.util.List;

public interface TenderService {
    public List<Tender>getAll();
    public Tender add(Tender tender);
    public Tender getTender(int id);
    public void delete(int id);

    public Link getLink(int id) throws IOException;
}
