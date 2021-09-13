package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.*;

import java.util.*;

public class TicketColumnModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<TicketColumnData> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<TicketColumnData> getData() {
        return data;
    }

    public void setData(ArrayList<TicketColumnData> data) {
        this.data = data;
    }

}
