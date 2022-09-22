package com.calisto.spring.rest_api.enums;

public enum DocumentBlock {
    AKKREDIT ("akkredit"),
    BUHDOC ("buhdocuments"),
    CONTRACT ("contracts"),
    EMPLOYEE ("employees"),
    LICENSE ("licenses"),
    OBORUDOVANIE ("oborudovanies"),
    PRODACT ("prodacts"),
    COMPANY ("company");

    private String title;

    DocumentBlock() {
    }

    DocumentBlock(String s) {
        this.title = s;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "DocumentBlock{" +
                "title='" + title + '\'' +
                '}';
    }
}
