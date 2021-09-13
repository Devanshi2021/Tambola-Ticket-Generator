package com.devanshi.tambola.ticketgenerator.app.model;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameIdModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<GameIdData> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<GameIdData> getData() {
        return data;
    }

    public void setData(ArrayList<GameIdData> data) {
        this.data = data;
    }

}
