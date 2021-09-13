package com.devanshi.tambola.ticketgenerator.app.model;

import java.util.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClaimListModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<ClaimListData> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ClaimListModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ArrayList<ClaimListData> getData() {
        return data;
    }

    public void setData(ArrayList<ClaimListData> data) {
        this.data = data;
    }

    public ClaimListModel withData(ArrayList<ClaimListData> data) {
        this.data = data;
        return this;
    }

}
