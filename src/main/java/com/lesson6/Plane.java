package com.lesson6;

import java.util.Date;

public class Plane {

    Long id;
    String model;
    String code;
    Date yearProduced;
    Double avgFuelConsumption;

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getCode() {
        return code;
    }

    public Date getYearProduced() {
        return yearProduced;
    }

    public Double getAvgFuelConsumption() {
        return avgFuelConsumption;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setYearProduced(Date yearProduced) {
        this.yearProduced = yearProduced;
    }

    public void setAvgFuelConsumption(Double avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }
}
