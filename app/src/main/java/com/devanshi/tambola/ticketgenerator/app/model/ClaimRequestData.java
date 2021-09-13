package com.devanshi.tambola.ticketgenerator.app.model;

import android.os.*;

import ir.mirrajabi.searchdialog.core.*;

public class ClaimRequestData implements Searchable, Parcelable {
    private String id;
    private String title;

    public ClaimRequestData(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
    }

    public static final Creator<ClaimRequestData> CREATOR = new Creator<ClaimRequestData>() {
        @Override
        public ClaimRequestData createFromParcel(Parcel in) {
            return new ClaimRequestData(in);
        }

        @Override
        public ClaimRequestData[] newArray(int size) {
            return new ClaimRequestData[size];
        }
    };

    public ClaimRequestData(String title, String id) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClaimRequestData withId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = title;
    }

    public ClaimRequestData withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {

        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
    }
}
