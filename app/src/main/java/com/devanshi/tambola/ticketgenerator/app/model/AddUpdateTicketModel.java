
package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.*;

public class AddUpdateTicketModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ListTicketData data = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public AddUpdateTicketModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ListTicketData getListTicketData() {
        return data;
    }

    public void setListTicketData(ListTicketData data) {
        this.data = data;
    }

    public AddUpdateTicketModel withData(ListTicketData data) {
        this.data = data;
        return this;
    }

}
