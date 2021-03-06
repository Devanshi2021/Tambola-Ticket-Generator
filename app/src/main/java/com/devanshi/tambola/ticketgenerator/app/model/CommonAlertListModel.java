package com.devanshi.tambola.ticketgenerator.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ir.mirrajabi.searchdialog.core.Searchable;

/**
 * Purpose:
 */

public class CommonAlertListModel implements Searchable,Parcelable {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("id")
    @Expose
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.id);
    }

    public CommonAlertListModel() {
    }

    protected CommonAlertListModel(Parcel in) {
        this.name = in.readString();
        this.id = in.readInt();
    }

    public static final Creator<CommonAlertListModel> CREATOR = new Creator<CommonAlertListModel>() {
        @Override
        public CommonAlertListModel createFromParcel(Parcel source) {
            return new CommonAlertListModel(source);
        }

        @Override
        public CommonAlertListModel[] newArray(int size) {
            return new CommonAlertListModel[size];
        }
    };

    @Override
    public String getTitle() {
        return name;
    }
}
