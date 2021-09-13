package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.*;

import java.util.*;

public class WalletRechargeModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<WalletRechargeData> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public WalletRechargeModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ArrayList<WalletRechargeData> getData() {
        return data;
    }

    public void setData(ArrayList<WalletRechargeData> data) {
        this.data = data;
    }

    public WalletRechargeModel withData(ArrayList<WalletRechargeData> data) {
        this.data = data;
        return this;
    }

}
