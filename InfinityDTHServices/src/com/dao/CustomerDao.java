package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Address;
import com.bean.Customer;
import com.bean.User;
import com.dao.interfaces.ICustomerDao;
import com.util.DBConnection;

public class CustomerDao extends GenericDao implements ICustomerDao {

	public ResultSet selectSQL(String sql) {
	
		ResultSet result=null;
		Connection conn=null;
		
		try {
			conn=DBConnection.getConnection();
			PreparedStatement preStatement = conn.prepareStatement(sql);
			result=preStatement.executeQuery();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public Integer addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		
		Integer userId = addNewUser(customer, User.CUSTOMER);
		
		con = DBConnection.getConnectionTest();
		
		AddressDao addressDao = new AddressDao();
		
		Integer addressId = addressDao.addAddress(customer.getAddress());
		
		String sql = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?)";
		
		logger.info(sql);
		
		ps = con.prepareStatement(sql);
		
		ps.setInt(1, userId);
		ps.setString(2,customer.getFirstName());
		ps.setString(3,customer.getLastName());
		ps.setString(4,customer.getEmailAddress());
		ps.setString(5,customer.getPhoneNumber());
		ps.setInt(6, addressId);
		
		ps.executeUpdate();

//		query = "select XUsers_Sequences.currval from dual";
//		stmt = con.createStatement();
//		rs = stmt.executeQuery(query);
//		
//		while(rs.next()) {
//			Integer customerId = rs.getInt(1);
//			logger.info("CustomerID: " + customerId);
//			return customerId;
//		}
		
		System.out.println("end");
		
		DBConnection.CloseConnection(con);
		
//		return -1;
		return userId;
	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		ArrayList<Customer> customers = new ArrayList<>();
		Address address=new Address();
		
		// Get connection
		con = DBConnection.getConnection();
		
		// Prepare SQL statement
		try {
			ps = con.prepareStatement("select * from Customer");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				
				customer.setUserId(rs.getInt("userId"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setPhoneNumber(rs.getString("phonenumber"));
				customer.setEmailAddress(rs.getString("emailid"));
//				address.setAddressId(Integer.parseInt(rs.getString("addressid")));
//				customer.getAddress().getAddress1()
				
				customers.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Execute SQL statement
		
		
		return customers;
	}

	@Override
	public List<Customer> getCustomerByName(String customerName)
			throws SQLException, ClassNotFoundException {
		
		ArrayList<Customer> customers = new ArrayList<>();
		Address address=new Address();
		
		con = DBConnection.getConnection();
		
		try {
			ps = con.prepareStatement("select * from Customer where firstname= "+"'"+customerName+"'");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setPhoneNumber(rs.getString("phonenumber"));
				customer.setEmailAddress(rs.getString("emailid"));
				address.setAddressId(Integer.parseInt(rs.getString("addressid")));
//				customer.getAddress().getAddress1()
				
				customers.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}
	
	public void updateCustomer(Customer customer,int userid){

		con = DBConnection.getConnection();
//		String sql = "update customer set firstname= "+"'"+customer.getFirstName()+"'"
//					 +"lastname= "+"'"+customer.getLastName()+"'"+
//				     "phonenumber = "+"'"+customer.getPhoneNumber()+"'"+
//				     "emailid= "+"'"+customer.getEmailAddress()+"'";
		
		System.out.println("firstname= "+customer.getFirstName());
		String sql = "update customer set firstname= "+"'"+customer.getFirstName()+"'"+
					 " where userid="+userid;
		
//		System.out.println(customerid);
		System.out.println(sql);
		try {

			PreparedStatement ps=con.prepareStatement(sql);
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");
	}
	
	public void deleteCustomer(int customerid){

		con = DBConnection.getConnection();
		String sql = "delete from customer where customerid= "+customerid;
		
//		System.out.println(customerid);
		System.out.println(sql);
		try {

			PreparedStatement ps=con.prepareStatement(sql);
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");
	}
}









