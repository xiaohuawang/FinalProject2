package com.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.bean.Retailer;

public interface IRetailerDao {

	public Integer addRetailer(Retailer retailer) throws SQLException, ClassNotFoundException;

	public List<Retailer> getAllRetailers() throws SQLException, ClassNotFoundException;
	
	public Retailer getRetailerByName(String name) throws SQLException, ClassNotFoundException;
}
