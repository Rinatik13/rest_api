package com.calisto.spring.rest_api.communication.ApiDiskYandex.entity;

public class Link {
    private String href;
    private String method;
    private boolean templated;

    public Link() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isTemplated() {
        return templated;
    }

    public void setTemplated(boolean templated) {
        this.templated = templated;
    }

    @Override
    public String toString() {
        return "Link{" +
                "href='" + href + '\'' +
                "\n, method='" + method + '\'' +
                "\n, templated=" + templated +
                '}';
    }
}
