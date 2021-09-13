package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.*;

import java.util.*;

public class NewWalletRechargeModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<NewWalletRechargeData> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public NewWalletRechargeModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ArrayList<NewWalletRechargeData> getData() {
        return data;
    }

    public void setData(ArrayList<NewWalletRechargeData> data) {
        this.data = data;
    }

    public NewWalletRechargeModel withData(ArrayList<NewWalletRechargeData> data) {
        this.data = data;
        return this;
    }

}
