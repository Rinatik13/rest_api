package com.calisto.spring.rest_api.entity;

// периоды времени по рассматриваемым годам
// отмечает объект к какому периоду времени относится
public enum PeriodOfTime {

    // текущий год
    CURRENTYEAR(0),
    // предыдущий год
    FIRSTYEAR(1),
    // следующий за предыдущим год
    SECONDYEAR(2),
    // следующий год
    THIRDYEAR(3);

    private int yearStatus;

    PeriodOfTime(int yearStatus) {
        this.yearStatus = yearStatus;
    }

    public int getYearStatus() {
        return yearStatus;
    }

    public void setYearStatus(int yearStatus) {
        this.yearStatus = yearStatus;
    }
}
