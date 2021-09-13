package com.devanshi.tambola.ticketgenerator.app.model;

import androidx.annotation.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListTicketData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("serial_index_id")
    @Expose
    private Integer serialIndexId;
    @SerializedName("from_serial_no")
    @Expose
    private Integer fromSerialNo;
    @SerializedName("to_serial_no")
    @Expose
    private Integer toSerialNo;
    @SerializedName("column_id")
    @Expose
    private Integer columnId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("alpabet_serial_index")
    @Expose
    private String alpabetSerialIndex;
    @SerializedName("ticket_column_title")
    @Expose
    private String ticketColumnTitle;
    @SerializedName("status")
    @Expose
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ListTicketData withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSerialIndexId() {
        return serialIndexId;
    }

    public void setSerialIndexId(Integer serialIndexId) {
        this.serialIndexId = serialIndexId;
    }

    public ListTicketData withSerialIndexId(Integer serialIndexId) {
        this.serialIndexId = serialIndexId;
        return this;
    }

    public Integer getFromSerialNo() {
        return fromSerialNo;
    }

    public void setFromSerialNo(Integer fromSerialNo) {
        this.fromSerialNo = fromSerialNo;
    }

    public ListTicketData withFromSerialNo(Integer fromSerialNo) {
        this.fromSerialNo = fromSerialNo;
        return this;
    }

    public Integer getToSerialNo() {
        return toSerialNo;
    }

    public void setToSerialNo(Integer toSerialNo) {
        this.toSerialNo = toSerialNo;
    }

    public ListTicketData withToSerialNo(Integer toSerialNo) {
        this.toSerialNo = toSerialNo;
        return this;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public ListTicketData withColumnId(Integer columnId) {
        this.columnId = columnId;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ListTicketData withImage(String image) {
        this.image = image;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public ListTicketData withCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ListTicketData withUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public ListTicketData withDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    public String getAlpabetSerialIndex() {
        return alpabetSerialIndex;
    }

    public void setAlpabetSerialIndex(String alpabetSerialIndex) {
        this.alpabetSerialIndex = alpabetSerialIndex;
    }

    public ListTicketData withAlpabetSerialIndex(String alpabetSerialIndex) {
        this.alpabetSerialIndex = alpabetSerialIndex;
        return this;
    }

    public String getTicketColumnTitle() {
        return ticketColumnTitle;
    }

    public void setTicketColumnTitle(String ticketColumnTitle) {
        this.ticketColumnTitle = ticketColumnTitle;
    }

    public ListTicketData withTicketColumnTitle(String ticketColumnTitle) {
        this.ticketColumnTitle = ticketColumnTitle;
        return this;
    }

    @NonNull
    public String toString(){
        if (updatedAt == null) updatedAt ="";
        if (createdAt == null) createdAt ="";
        return id+","+
                serialIndexId+","+
                fromSerialNo+","+
                toSerialNo+","+
                columnId+","+
                updatedAt+","+
                createdAt+","+
                alpabetSerialIndex+","+
                ticketColumnTitle+","+
                image+","+
                status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
