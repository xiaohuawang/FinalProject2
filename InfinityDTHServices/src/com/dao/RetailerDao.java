package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Retailer;
import com.bean.User;
import com.dao.interfaces.IRetailerDao;
import com.util.DBConnection;

public class RetailerDao extends GenericDao implements IRetailerDao {

	public Integer addRetailer(Retailer retailer) throws SQLException, ClassNotFoundException{
		Integer userId = addNewUser(retailer, User.OPERATOR);
		
		// Add Address
		AddressDao addressDao = new AddressDao();
		Integer addressId = addressDao.addAddress(retailer.getAddress());
				
		String sql = "INSERT INTO OPERATOR VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		ps = con.prepareStatement(sql);
		
		ps.setInt(1, userId);
		ps.setString(2, retailer.getName());
		ps.setString(3, retailer.getContactNo1());
		ps.setString(4, retailer.getContactNo2());
		ps.setInt(5, addressId);
		
		// USE THIS TO CONVERT DATES FROM java.util.Date TO java.sql.Date
		

		ps.setInt(6, retailer.getSetTopBoxLimit());
		ps.setDouble(7, retailer.getCreditLimit());
		ps.setDouble(8,  retailer.getCommissionPercentage());
		ps.setDouble(9, retailer.getServiceCharges());
		java.sql.Date sqlDate = this.convertDate(retailer.getRetailerCreationDate());
		ps.setDate(10, sqlDate);
			
		ps.executeUpdate();
		
		/*
		 * retailerId		INTEGER 		REFERENCES XUsers(userId),
		 	name 			VARCHAR(30) 	NOT NULL,
		 	contactNo1 		VARCHAR(30) 	NOT NULL,
		 	contactNo2 		VARCHAR(30)		NULL,
		 	addressId 		INTEGER 		REFERENCES Address(addressId),
		  	--Set Top Box Limit
		 	STBL 			VARCHAR(30) 	NOT NULL,
		 	creditLimit 	VARCHAR(30) 	NOT NULL,
		 	--Commission percentage on sale of goods
		 	CPSG 			VARCHAR(30) 	NOT NULL,
		 	serviceCharge 	VARCHAR(30) 	NOT NULL,
		 	--Retailer Creation Date
		 	creationDate	DATE 			NOT NULL,
		 	--Total Cost of Inventory
		 	TCI 			DECIMAL 		NOT NULL
		 * 
		 */
		
		
		
		logger.info("END");
		
		return -1;
		
		
	}
	
	public Retailer getRetailerByName(String name) throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();
		
		ps = con.prepareStatement("Select * from Retailer where name = ?");
		ps.setString(1, name);
		
		rs = ps.executeQuery();
		
		if(rs.next()){
			Retailer retailer = new Retailer();
			retailer.setUserId(rs.getInt("retailerId"));
			retailer.setName(rs.getString("name"));
			
			return retailer;
		}
		return null;
	}
	
	public List<Retailer> getAllRetailers() throws SQLException, ClassNotFoundException {
		List<Retailer> retailers = new ArrayList<>();
		
		con = DBConnection.getConnection();
		
		ps = con.prepareStatement("Select * from Retailer");
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			Retailer retailer = new Retailer();
			retailer.setUserId(rs.getInt("retailerId"));
			retailer.setName(rs.getString("name"));
			
			retailers.add(retailer);
		}
		return retailers;
			
	}
}
