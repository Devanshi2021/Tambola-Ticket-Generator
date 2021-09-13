package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.*;

public class ClaimListData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("game_id")
    @Expose
    private Integer gameId;
    @SerializedName("transaction_id")
    @Expose
    private Integer transactionId;
    @SerializedName("claim_type")
    @Expose
    private String claimType;
    @SerializedName("claim_ticket_image")
    @Expose
    private String claimTicketImage;
    @SerializedName("claim_status")
    @Expose
    private String claimStatus;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
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

    public ClaimListData withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public ClaimListData withGameId(Integer gameId) {
        this.gameId = gameId;
        return this;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public ClaimListData withTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public ClaimListData withClaimType(String claimType) {
        this.claimType = claimType;
        return this;
    }

    public String getClaimTicketImage() {
        return claimTicketImage;
    }

    public void setClaimTicketImage(String claimTicketImage) {
        this.claimTicketImage = claimTicketImage;
    }

    public ClaimListData withClaimTicketImage(String claimTicketImage) {
        this.claimTicketImage = claimTicketImage;
        return this;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public ClaimListData withClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public ClaimListData withCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ClaimListData withUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public ClaimListData withDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }
}
