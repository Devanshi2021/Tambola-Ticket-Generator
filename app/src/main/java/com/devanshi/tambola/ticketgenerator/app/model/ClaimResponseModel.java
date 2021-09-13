package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClaimResponseModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private ClaimResponseData data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ClaimResponseModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public ClaimResponseData getData() {
        return data;
    }

    public void setData(ClaimResponseData data) {
        this.data = data;
    }

    public ClaimResponseModel withData(ClaimResponseData data) {
        this.data = data;
        return this;
    }

}
