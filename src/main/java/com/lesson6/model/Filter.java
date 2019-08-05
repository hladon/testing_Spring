package com.lesson6.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Filter {

    private Date dateFrom;
    private Date dateTo;
    private String cityFrom;
    private String cityTo;

    public Filter() {
    }

    public Filter(Date dateFrom, Date dateTo, String cityFrom, String cityTo, String planeModel) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }
    @JsonProperty("dateFrom")
    public void setDateFrom(String dateFrom) throws Exception {
        this.dateFrom =new SimpleDateFormat("dd/MM/yyyy").parse(dateFrom);
    }
    @JsonProperty("dateTo")
    public void setDateTo(String dateTo) throws Exception{
        this.dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(dateTo);
    }
    @JsonProperty("cityFrom")
    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }
    @JsonProperty("cityTo")
    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                '}';
    }
}