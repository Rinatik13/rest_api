package com.calisto.spring.rest_api.entity;

public enum TypeOfTender {
    WORK(0),
    SERVICES(1),
    products(2);

    int typeNumber;

    TypeOfTender(int typeNumber) {
        this.typeNumber = typeNumber;
    }
}
