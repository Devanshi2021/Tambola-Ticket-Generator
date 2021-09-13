package com.devanshi.tambola.ticketgenerator.app.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseRespModel{

	@SerializedName("message")
	@Expose
	private String message;

	@SerializedName("status")
	@Expose
	private String status;

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
			"BaseRespModel{" + 
			"message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}