
package com.devanshi.tambola.ticketgenerator.app.model;

import java.util.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListTicketModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ArrayList<ListTicketData> data = new ArrayList<>();

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ListTicketModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ArrayList<ListTicketData> getListTicketData() {
        return data;
    }

    public void setListTicketData(ArrayList<ListTicketData> data) {
        this.data = data;
    }

    public ListTicketModel withData(ArrayList<ListTicketData> data) {
        this.data = data;
        return this;
    }

    public String toString(){
        return "meta: "+meta+"\ndata: "+data;
    }
}
