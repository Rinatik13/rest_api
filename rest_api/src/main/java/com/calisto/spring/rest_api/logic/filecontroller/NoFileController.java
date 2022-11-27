package com.calisto.spring.rest_api.logic.filecontroller;

// класс контролирует удаление файла

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import org.apache.log4j.Logger;

public class NoFileController extends Thread{
    private static final Logger log = Logger.getLogger(NoFileController.class);
        private String addressFile;
        private void deleteFile(){
            ControllerCommunication communication = new ControllerCommunication();
            communication.delete(addressFile);
        }

    @Override
    public void run() {
        try {
            log.info("получили команду на удаление файла: " + addressFile);
            Thread.sleep(300000);
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
