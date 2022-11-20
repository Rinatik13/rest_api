package com.calisto.spring.rest_api.logic.filecontroller;

// класс контролирует удаление файла

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import org.springframework.beans.factory.annotation.Autowired;

public class NoFileController extends Thread{
        private String addressFile;
        private void deleteFile(){
            ControllerCommunication communication = new ControllerCommunication();
            communication.delete(addressFile);
            System.out.println("Удалили файл по адресу: " + addressFile);
        }

    @Override
    public void run() {
        try {
            Thread.sleep(30000);
            deleteFile();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            Thread.yield();
        }
    }

    public String getAddressFile() {
        return addressFile;
    }

    public void setAddressFile(String addressFile) {
        this.addressFile = addressFile;
    }
}
