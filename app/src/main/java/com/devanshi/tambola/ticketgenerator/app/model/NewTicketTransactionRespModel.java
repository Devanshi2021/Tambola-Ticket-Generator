package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.*;

public class NewTicketTransactionRespModel {
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private NewTicketTransactionData data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public NewTicketTransactionRespModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public NewTicketTransactionData getData() {
        return data;
    }

    public void setData(NewTicketTransactionData data) {
        this.data = data;
    }

    public NewTicketTransactionRespModel withData(NewTicketTransactionData data) {
        this.data = data;
        return this;
    }

}
