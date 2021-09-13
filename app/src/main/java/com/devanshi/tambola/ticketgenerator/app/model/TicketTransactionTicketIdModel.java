package com.devanshi.tambola.ticketgenerator.app.model;

import android.os.*;

import ir.mirrajabi.searchdialog.core.*;

public class TicketTransactionTicketIdModel implements Searchable, Parcelable {
    private String title;
    private int value;

    protected TicketTransactionTicketIdModel(Parcel in) {
        this.title = in.readString();
        this.value = in.readInt();
    }

    public TicketTransactionTicketIdModel(String title, int value) {
        this.title = title;
        this.value = value;
    }

    public static final Creator<TicketTransactionTicketIdModel> CREATOR = new Creator<TicketTransactionTicketIdModel>() {
        @Override
        public TicketTransactionTicketIdModel createFromParcel(Parcel in) {
            return new TicketTransactionTicketIdModel(in);
        }

        @Override
        public TicketTransactionTicketIdModel[] newArray(int size) {
            return new TicketTransactionTicketIdModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TicketTransactionTicketIdModel withTitle(String title) {
        this.title = title;
        return this;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TicketTransactionTicketIdModel withValue(int value) {
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
        dest.writeInt(this.value);
    }
}
