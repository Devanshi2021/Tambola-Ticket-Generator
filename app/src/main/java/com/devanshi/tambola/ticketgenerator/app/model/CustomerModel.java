package com.devanshi.tambola.ticketgenerator.app.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ir.mirrajabi.searchdialog.core.Searchable;


public class CustomerModel implements Searchable {

    @SerializedName("contact_no")
    @Expose
    private String contact_no;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("city_id")
    @Expose
    private String city_id;

    @SerializedName("full_name")
    @Expose
    private String full_name;

    @SerializedName("city_name")
    @Expose
    private String city_name;

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return contact_no + ',' + name + ',' + id +','+ city_id + ',' + full_name + ',' + city_name;
    }

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCity_id() {
		return city_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	@Override
	public String getTitle() {
    	return "";
	}
}