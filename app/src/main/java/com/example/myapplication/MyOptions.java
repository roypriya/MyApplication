package com.example.myapplication;

public class MyOptions {
    String options;
    int resid;

    public MyOptions(String options,int id) {
        this.options = options;
        this.resid=id;

    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
