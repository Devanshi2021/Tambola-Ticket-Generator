package com.devanshi.tambola.ticketgenerator.app.model;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CityRespModel{

	@SerializedName("data")
	@Expose
	private ArrayList<CommonAlertListModel> data;

	@SerializedName("meta")
	@Expose
	private Meta meta;

	public void setData(ArrayList<CommonAlertListModel> data){
		this.data = data;
	}

	public ArrayList<CommonAlertListModel> getData(){
		return data;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	@Override
 	public String toString(){
		return 
			"CityRespModel{" + 
			"meta = '" + meta + '\'' +
			"data = '" + data + '\'' +
			"}";
		}
}