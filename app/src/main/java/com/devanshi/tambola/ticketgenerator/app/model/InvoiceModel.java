package com.devanshi.tambola.ticketgenerator.app.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvoiceModel {

	@SerializedName("contact_no")
	@Expose
	private String contact_no;

	@SerializedName("date")
	@Expose
	private String date;

	@SerializedName("total_amount")
	@Expose
	private String totalAmount;

	@SerializedName("product_id")
	@Expose
	private int productId;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("customer_name")
	@Expose
	private String customerName;

	@SerializedName("customer_id")
	@Expose
	private int customerId;

	@SerializedName("product_name")
	@Expose
	private String productName;

	@SerializedName("invoice_key")
	@Expose
	private String invoiceKey;

	@SerializedName("discount_amount")
	@Expose
	private String discount_amount;

	@SerializedName("quntity")
	@Expose
	private String quntity;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setTotalAmount(String totalAmount){
		this.totalAmount = totalAmount;
	}

	public String getTotalAmount(){
		return totalAmount;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductId(){
		return productId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	public String getCustomerName(){
		return customerName;
	}

	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}

	public int getCustomerId(){
		return customerId;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setInvoiceKey(String invoiceKey){
		this.invoiceKey = invoiceKey;
	}

	public String getInvoiceKey(){
		return invoiceKey;
	}

	public void setQuntity(String quntity){
		this.quntity = quntity;
	}

	public String getQuntity(){
		return quntity;
	}


	public String getDiscount_amount() {
		return discount_amount;
	}

	public void setDiscount_amount(String discount_amount) {
		this.discount_amount = discount_amount;
	}

	public String getContact_no() {
		if (contact_no == null)
			contact_no = "+911234567890";
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	@Override
 	public String toString(){
		return 
			"InvoiceModel{" +
			"date = '" + date + '\'' + 
			",total_amount = '" + totalAmount + '\'' + 
			",product_id = '" + productId + '\'' + 
			",id = '" + id + '\'' + 
			",customer_name = '" + customerName + '\'' + 
			",customer_id = '" + customerId + '\'' +
			",contact_no = '" + contact_no + '\'' +
			",discount_amount = '" + discount_amount + '\'' +
			",product_name = '" + productName + '\'' +
			",invoice_key = '" + invoiceKey + '\'' + 
			",quntity = '" + quntity + '\'' + 
			"}";
		}
}