package com.devanshi.tambola.ticketgenerator.app.model;

import android.os.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ir.mirrajabi.searchdialog.core.*;

public class ClaimTransactionListData implements Searchable, Parcelable {

    @SerializedName("player_name")
    @Expose
    private String playerName;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("token_id")
    @Expose
    private Integer tokenId;

    protected ClaimTransactionListData(Parcel in) {
        this.playerName = in.readString();
        if (in.readByte() == 0) {
            this.amount = null;
        } else {
            this.amount = in.readInt();
        }
        this.createdAt = in.readString();
        if (in.readByte() == 0) {
            this.tokenId = null;
        } else {
            this.tokenId = in.readInt();
        }
    }

    public static final Creator<ClaimTransactionListData> CREATOR = new Creator<ClaimTransactionListData>() {
        @Override
        public ClaimTransactionListData createFromParcel(Parcel in) {
            return new ClaimTransactionListData(in);
        }

        @Override
        public ClaimTransactionListData[] newArray(int size) {
            return new ClaimTransactionListData[size];
        }
    };

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ClaimTransactionListData withPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ClaimTransactionListData withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ClaimTransactionListData withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public ClaimTransactionListData withTokenId(Integer tokenId) {
        this.tokenId = tokenId;
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
        dest.writeString(playerName);
        if (amount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(amount);
        }
        dest.writeString(createdAt);
        if (tokenId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(tokenId);
        }
    }

    @Override
    public String getTitle() {
        return getPlayerName()+"-"+getTokenId();
    }
}
