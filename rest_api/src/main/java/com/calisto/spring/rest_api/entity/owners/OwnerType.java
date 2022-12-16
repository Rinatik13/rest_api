package com.calisto.spring.rest_api.entity.owners;

public enum OwnerType {
    Company(0),
    Human(1);

    int typeNumber;

    OwnerType(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(int typeNumber) {
        this.typeNumber = typeNumber;
    }
}
