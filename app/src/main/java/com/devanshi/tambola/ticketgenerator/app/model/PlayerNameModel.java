package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.*;

public class PlayerNameModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<PlayerNameData> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public PlayerNameModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ArrayList<PlayerNameData> getData() {
        return data;
    }

    public void setData(ArrayList<PlayerNameData> data) {
        this.data = data;
    }

    public PlayerNameModel withData(ArrayList<PlayerNameData> data) {
        this.data = data;
        return this;
    }

}
