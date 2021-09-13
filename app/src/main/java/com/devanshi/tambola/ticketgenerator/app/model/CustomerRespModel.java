package com.devanshi.tambola.ticketgenerator.app.model;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerRespModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<CustomerModel> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public CustomerRespModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ArrayList<CustomerModel> getData() {
        return data;
    }

    public void setData(ArrayList<CustomerModel> data) {
        this.data = data;
    }

    public CustomerRespModel withData(ArrayList<CustomerModel> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "";
    }
}