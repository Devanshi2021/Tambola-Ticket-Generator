package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewWalletRechargeData {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NewWalletRechargeData withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public NewWalletRechargeData withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NewWalletRechargeData withDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public NewWalletRechargeData withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NewWalletRechargeData withType(String type) {
        this.type = type;
        return this;
    }

    public Integer getRechargedBy() {
        return rechargedBy;
    }

    public void setRechargedBy(Integer rechargedBy) {
        this.rechargedBy = rechargedBy;
    }

    public NewWalletRechargeData withRechargedBy(Integer rechargedBy) {
        this.rechargedBy = rechargedBy;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public NewWalletRechargeData withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public NewWalletRechargeData withUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public NewWalletRechargeData withDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

}
