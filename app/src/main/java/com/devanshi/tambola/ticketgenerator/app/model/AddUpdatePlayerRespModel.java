package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddUpdatePlayerRespModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("addUpdatePlayerData")
    @Expose
    private AddUpdatePlayerData addUpdatePlayerData;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public AddUpdatePlayerRespModel withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public AddUpdatePlayerData getAddUpdatePlayerData() {
        return addUpdatePlayerData;
    }

    public void setAddUpdatePlayerData(AddUpdatePlayerData addUpdatePlayerData) {
        this.addUpdatePlayerData = addUpdatePlayerData;
    }

    public AddUpdatePlayerRespModel withData(AddUpdatePlayerData addUpdatePlayerData) {
        this.addUpdatePlayerData = addUpdatePlayerData;
        return this;
    }

}
