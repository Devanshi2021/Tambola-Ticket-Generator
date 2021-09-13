package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.*;

import java.util.*;

public class TicketTransactionRespModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<TicketTransactionData> data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public TicketTransactionRespModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ArrayList<TicketTransactionData> getData() {
        return data;
    }

    public void setData(ArrayList<TicketTransactionData> data) {
        this.data = data;
    }

    public TicketTransactionRespModel withData(ArrayList<TicketTransactionData> data) {
        this.data = data;
        return this;
    }
}
