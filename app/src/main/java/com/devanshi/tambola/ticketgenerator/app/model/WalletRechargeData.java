package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.*;

public class WalletRechargeData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("recharged_by")
    @Expose
    private Integer rechargedBy;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("palyerName")
    @Expose
    private String palyerName;
    @SerializedName("recharged_by_name")
    @Expose
    private String rechargedByName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WalletRechargeData withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public WalletRechargeData withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WalletRechargeData withDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public WalletRechargeData withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WalletRechargeData withType(String type) {
        this.type = type;
        return this;
    }

    public Integer getRechargedBy() {
        return rechargedBy;
    }

    public void setRechargedBy(Integer rechargedBy) {
        this.rechargedBy = rechargedBy;
    }

    public WalletRechargeData withRechargedBy(Integer rechargedBy) {
        this.rechargedBy = rechargedBy;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public WalletRechargeData withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public WalletRechargeData withUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public WalletRechargeData withDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    public String getPalyerName() {
        return palyerName;
    }

    public void setPalyerName(String palyerName) {
        this.palyerName = palyerName;
    }

    public WalletRechargeData withPalyerName(String palyerName) {
        this.palyerName = palyerName;
        return this;
    }

    public String getRechargedByName() {
        return rechargedByName;
    }

    public void setRechargedByName(String rechargedByName) {
        this.rechargedByName = rechargedByName;
    }

    public WalletRechargeData withRechargedByName(String rechargedByName) {
        this.rechargedByName = rechargedByName;
        return this;
    }
}

