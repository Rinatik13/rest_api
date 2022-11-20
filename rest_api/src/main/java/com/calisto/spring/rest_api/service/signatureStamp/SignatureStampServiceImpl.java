package com.calisto.spring.rest_api.service.signatureStamp;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.DaO.signatureStamp.SignatureStampDaO;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Image_jpg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SignatureStampServiceImpl implements SignatureStampService{

    @Autowired
    CompanyDaO companyDaO;

    @Autowired
    SignatureStampDaO signatureStampDaO;

    @Override
    @Transactional
    public List<Image_jpg> getAll() {
        return signatureStampDaO.getAll();
    }

    @Override
    @Transactional
    public Image_jpg add(Image_jpg imageJpg) {
        ControllerCommunication controller = new ControllerCommunication();
        System.out.println("Загрузка файла: " + imageJpg.getName());

        Company company = companyDaO.getCompany(imageJpg.getCompany_id());
        imageJpg.setAddress("user_" + company.getUser_id() + "/company_" +
                company.getId() + "/signatureStamp");

        addNewImageJPGSignatureStamp(company, imageJpg);
        companyDaO.add(company);
        String url = controller.getUploadFile(imageJpg.getAddress() + "/" + imageJpg.getName() + ".jpg")
                .getHref();
        controller.uploadFile(url,"PUT", imageJpg.getBody());
        return imageJpg;
    }

    @Override
    @Transactional
    public Image_jpg getImageJPG(int id) {
        return signatureStampDaO.getImageJPG(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        signatureStampDaO.delete(id);
    }

    @Override
    @Transactional
    public Image_jpg editImageJPG(Image_jpg imageJpg) {
        return signatureStampDaO.add(imageJpg);
    }


    private void addNewImageJPGSignatureStamp(Company company, Image_jpg imageJpg){
        if ("signature".equals(imageJpg.getBlock())){
            company.getSignatureList().add(imageJpg);
        }
        else {
            company.getStampList().add(imageJpg);
        }
    }
}
