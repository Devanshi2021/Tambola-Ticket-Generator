package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.*;

import java.util.*;

public class TicketSerialModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<TicketSerialData> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<TicketSerialData> getData() {
        return data;
    }

    public void setData(ArrayList<TicketSerialData> data) {
        this.data = data;
    }

}
