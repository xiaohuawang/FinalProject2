package com.bean;

/*TO DO: Inventory List(Object/ArrayList), Total Cost of Inventory
 * 		 Status of Inventory given to Retailer
 */

import java.util.Date;

public class Retailer extends User {
	
	private String name;
	private String contactNo1;
	private String contactNo2;
	private Address address;
	private int setTopBoxLimit;
	private double creditLimit;
	private double commissionPercentage;
	private double serviceCharges;
	private Date retailerCreationDate;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo1() {
		return contactNo1;
	}
	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}
	public String getContactNo2() {
		return contactNo2;
	}
	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}
	public int getSetTopBoxLimit() {
		return setTopBoxLimit;
	}
	public void setSetTopBoxLimit(int setTopBoxLimit) {
		this.setTopBoxLimit = setTopBoxLimit;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public double getCommissionPercentage() {
		return commissionPercentage;
	}
	public void setCommissionPercentage(double commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}
	public double getServiceCharges() {
		return serviceCharges;
	}
	public void setServiceCharges(double serviceCharges) {
		this.serviceCharges = serviceCharges;
	}
	public Date getRetailerCreationDate() {
		return retailerCreationDate;
	}
	public void setRetailerCreationDate(Date retailerCreationDate) {
		this.retailerCreationDate = retailerCreationDate;
	}
	
	@Override
	public String toString() {
		return new String("RetailerId: " + getUserId() + " Name: " + name);
	}
}
