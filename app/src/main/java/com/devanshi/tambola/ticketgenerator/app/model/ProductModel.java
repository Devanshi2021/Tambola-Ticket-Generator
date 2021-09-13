package com.devanshi.tambola.ticketgenerator.app.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductModel {

	@SerializedName("image")
	@Expose
	private String image;

	@SerializedName("price")
	@Expose
	private String price;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("status")
	@Expose
	private int status;

	@SerializedName("barcode")
	@Expose
	private String barcode;

	@SerializedName("qty")
	@Expose
	private String qty;

	@SerializedName("size")
	@Expose
	private String size;

	@SerializedName("color")
	@Expose
	private String color;

	private int minimumQty=0;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public int getMinimumQty() {
		return minimumQty;
	}

	public void setMinimumQty(int minimumQty) {
		this.minimumQty = minimumQty;
	}

	public void setBarcode(String barcode){
		this.barcode = barcode;
	}

	public String getBarcode(){
		return barcode;
	}

	public void setQty(String qty){
		this.qty = qty;
	}

	public String getQty(){
		return qty;
	}
	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}
	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	@Override
	public String toString(){
		return
				"ProductModel{" +
						"image = '" + image + '\'' +
						",price = '" + price + '\'' +
						",name = '" + name + '\'' +
						",description = '" + description + '\'' +
						",barcode = '" + barcode + '\'' +
						",id = '" + id + '\'' +
						",status = '" + status + '\'' +
						",qty = '" + qty + '\'' +
						",size = '" + size + '\'' +
						",color = '" + color + '\'' +
						"}";
	}
}