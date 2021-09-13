package com.devanshi.tambola.ticketgenerator.app.model;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductRespModel{

	@SerializedName("result")
	@Expose
	private ArrayList<ProductModel> result;

	@SerializedName("message")
	@Expose
	private String message;

	@SerializedName("status")
	@Expose
	private String status;

	public void setResult(ArrayList<ProductModel> result){
		this.result = result;
	}

	public ArrayList<ProductModel> getResult(){
		return result;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ProductRespModel{" + 
			"result = '" + result + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}