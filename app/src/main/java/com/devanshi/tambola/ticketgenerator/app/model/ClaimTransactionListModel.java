package com.devanshi.tambola.ticketgenerator.app.model;

import java.util.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClaimTransactionListModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<ClaimTransactionListData> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ClaimTransactionListModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ArrayList<ClaimTransactionListData> getData() {
        return data;
    }

    public void setData(ArrayList<ClaimTransactionListData> data) {
        this.data = data;
    }

    public ClaimTransactionListModel withData(ArrayList<ClaimTransactionListData> data) {
        this.data = data;
        return this;
    }

}
