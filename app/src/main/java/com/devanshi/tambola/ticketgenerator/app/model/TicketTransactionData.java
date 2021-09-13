package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TicketTransactionData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("player_id")
    @Expose
    private Integer playerId;
    @SerializedName("serial_index_id")
    @Expose
    private Integer serialIndexId;
    @SerializedName("column_id")
    @Expose
    private Integer columnId;
    @SerializedName("ticket_id")
    @Expose
    private Integer ticketId;
    @SerializedName("created_by_id")
    @Expose
    private Integer createdById;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("game_on")
    @Expose
    private String gameOn;
    @SerializedName("payed_by")
    @Expose
    private String payedBy;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("created_by_name")
    @Expose
    private String createdByName;
    @SerializedName("player_name")
    @Expose
    private String playerName;
    @SerializedName("alpabet_serial_index")
    @Expose
    private String alpabetSerialIndex;
    @SerializedName("ticket_column_title")
    @Expose
    private String ticketColumnTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TicketTransactionData withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public TicketTransactionData withPlayerId(Integer playerId) {
        this.playerId = playerId;
        return this;
    }

    public Integer getSerialIndexId() {
        return serialIndexId;
    }

    public void setSerialIndexId(Integer serialIndexId) {
        this.serialIndexId = serialIndexId;
    }

    public TicketTransactionData withSerialIndexId(Integer serialIndexId) {
        this.serialIndexId = serialIndexId;
        return this;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public TicketTransactionData withColumnId(Integer columnId) {
        this.columnId = columnId;
        return this;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public TicketTransactionData withTicketId(Integer ticketId) {
        this.ticketId = ticketId;
        return this;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public TicketTransactionData withCreatedById(Integer createdById) {
        this.createdById = createdById;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TicketTransactionData withImage(String image) {
        this.image = image;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public TicketTransactionData withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TicketTransactionData withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getGameOn() {
        return gameOn;
    }

    public void setGameOn(String gameOn) {
        this.gameOn = gameOn;
    }

    public TicketTransactionData withGameOn(String gameOn) {
        this.gameOn = gameOn;
        return this;
    }

    public String getPayedBy() {
        return payedBy;
    }

    public void setPayedBy(String payedBy) {
        this.payedBy = payedBy;
    }

    public TicketTransactionData withPayedBy(String payedBy) {
        this.payedBy = payedBy;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public TicketTransactionData withCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TicketTransactionData withUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public TicketTransactionData withDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public TicketTransactionData withCreatedByName(String createdByName) {
        this.createdByName = createdByName;
        return this;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public TicketTransactionData withPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public String getAlpabetSerialIndex() {
        return alpabetSerialIndex;
    }

    public void setAlpabetSerialIndex(String alpabetSerialIndex) {
        this.alpabetSerialIndex = alpabetSerialIndex;
    }

    public TicketTransactionData withAlpabetSerialIndex(String alpabetSerialIndex) {
        this.alpabetSerialIndex = alpabetSerialIndex;
        return this;
    }

    public String getTicketColumnTitle() {
        return ticketColumnTitle;
    }

    public void setTicketColumnTitle(String ticketColumnTitle) {
        this.ticketColumnTitle = ticketColumnTitle;
    }

    public TicketTransactionData withTicketColumnTitle(String ticketColumnTitle) {
        this.ticketColumnTitle = ticketColumnTitle;
        return this;
    }

}
