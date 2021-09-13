package com.devanshi.tambola.ticketgenerator.app.model;

import android.os.*;

import ir.mirrajabi.searchdialog.core.*;

public class TicketStatusData implements Searchable, Parcelable {
    private String title;
    private String value;

    protected TicketStatusData(Parcel in) {
        this.title = in.readString();
        this.value = in.readString();
    }

    public TicketStatusData(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public static final Creator<TicketStatusData> CREATOR = new Creator<TicketStatusData>() {
        @Override
        public TicketStatusData createFromParcel(Parcel in) {
            return new TicketStatusData(in);
        }

        @Override
        public TicketStatusData[] newArray(int size) {
            return new TicketStatusData[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TicketStatusData withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TicketStatusData withValue(String value) {
        this.value = value;
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
        dest.writeString(this.title);
        dest.writeString(this.value);
    }
}
