package com.company.model;


public class Subscriber {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog() {
        return username;
    }

    public void setLog(String log) {
        this.username = log;
    }

    public String getPas() {
        return password;
    }

    public void setPas(String pas) {
        this.password = pas;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", log='" + username + '\'' +
                ", pas='" + password + '\'' +
                '}';
    }
}