package com.calisto.spring.rest_api.entity;

public enum TypeOfTender {
    WORK(0),
    PRODUCTS(1),
    SERVICES(2);

    int typeNumber;

    TypeOfTender(int typeNumber) {
        this.typeNumber = typeNumber;
    }
}
