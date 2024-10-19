package com.study.model;


import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable  {

    private String id;
    private Date date;
    private Boolean seen;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", seen=" + seen +
                ", message='" + message + '\'' +
                '}';
    }
}
