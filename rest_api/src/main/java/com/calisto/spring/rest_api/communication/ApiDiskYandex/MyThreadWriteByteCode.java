package com.calisto.spring.rest_api.communication.ApiDiskYandex;

import org.apache.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;

public class MyThreadWriteByteCode implements Runnable{

    private static final Logger log = Logger.getLogger(MyThreadWriteByteCode.class);
    private DataOutputStream dataOutputStream;
    private byte[] arrayBody;
    @Override
    public void run() {
        log.info("начинаем работу с потоком загрузки данных");
        writeArrayBody(dataOutputStream,arrayBody);
    }
    private synchronized void writeArrayBody(DataOutputStream out, byte[] reqbody) {
        try {

            out.write(reqbody);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MyThreadWriteByteCode(DataOutputStream dataOutputStream, byte[] arrayBody) {
        this.dataOutputStream = dataOutputStream;
        this.arrayBody = arrayBody;
    }
}
