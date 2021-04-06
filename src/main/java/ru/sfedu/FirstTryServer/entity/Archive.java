package ru.sfedu.FirstTryServer.entity;

import java.util.Date;

public class Archive {
    private Date date;
    private String name;
    private Double size;

public Archive(Date date, String name, Double size){
    this.date=date;
    this.name=name;
    this.size=size;
}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}