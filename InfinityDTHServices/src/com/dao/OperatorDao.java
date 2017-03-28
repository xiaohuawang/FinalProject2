package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Operator;
import com.bean.User;
import com.dao.interfaces.IOperatorDao;
import com.util.DBConnection;

public class OperatorDao extends GenericDao implements IOperatorDao {
	
	@Override
	public Integer addOperator(Operator operator) throws SQLException, ClassNotFoundException {
		//		INSERT INTO ASSIGNMENT (STUDENT_ID,ASSIGNMENT_NAME,ASSIGNMENT_TYPE,ASSIGNMENT_DATE,GRADE) 
		//		VALUES (?,?,?,?,?)";

		Integer userId = addNewUser(operator, User.OPERATOR);

		String sql= "INSERT INTO OPERATOR VALUES(?,?,?,?,?,?,?,?,?)";
		// (USERID,FIRSTNAME,LASTNAME,EMAILID,PHONENUMBER,SHIFTTIMESTART, SHIFTTIMEEND, MAXNOCUSTOMERS, CREATIONDATE)
		
		ps = con.prepareStatement(sql);
		logger.info("Before userID");
		ps.setInt(1, userId);
		logger.info("After userID");
		ps.setString(2,operator.getFirstName());
		logger.info("After first name");
		ps.setString(3,operator.getLastName());
		logger.info("After last name");
		ps.setString(4,operator.getEmailAddress());
		logger.info("After email address");
		ps.setString(5,operator.getPhoneNumber());
		logger.info("After phone number");
		
		// USE THIS TO CONVERT DATES FROM java.util.Date TO java.sql.Date
	    java.sql.Date sqlDate = this.convertDate(operator.getShiftTimeStart());
		
		ps.setDate(6,sqlDate);
		logger.info("After shift time start");
		logger.info("shift time end"+operator.getShiftTimeEnd());
		// USE THIS TO CONVERT DATES FROM java.util.Date TO java.sql.Date
	    java.sql.Date sqlDate2 = this.convertDate(operator.getShiftTimeEnd());
		
		ps.setDate(7,sqlDate2);
		logger.info("After shift time end");
		ps.setInt(8,operator.getMaxNoCustomers());
		// USE THIS TO CONVERT DATES FROM java.util.Date TO java.sql.Date
	    java.sql.Date sqlDate3 = this.convertDate(operator.getCreationDate());
		ps.setDate(9,sqlDate3);
		ps.executeUpdate();
		
		logger.info("END");
		
		return userId;
	}
	
	@Override
	public ArrayList<Operator> getAllOperator() {
		ArrayList<Operator> operators = new ArrayList<>();		
		
		// Get connection
		con = DBConnection.getConnection();
		
		// Prepare SQL statement
		try {
			ps = con.prepareStatement("select * from Operator");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Operator operator = new Operator();
				
				operator.setFirstName(rs.getString("firstName"));
				operator.setLastName(rs.getString("lastName"));
				operator.setPhoneNumber(rs.getString("phonenumber"));
				operator.setEmailAddress(rs.getString("emailid"));
				operator.setCreationDate(rs.getDate("creationDate"));
				operator.setMaxNoCustomers(rs.getInt("mcm"));
				operator.setShiftTimeStart(rs.getDate("sts"));
				operator.setShiftTimeEnd(rs.getDate("ste"));
				operators.add(operator);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Execute SQL statement
		
		
		return operators;
	}

	@Override
	public List<Operator> getOperatorByName(String operatorName)
			throws SQLException, ClassNotFoundException {
		
		ArrayList<Operator> operators = new ArrayList<>();		
		
		con = DBConnection.getConnection();
		
		try {
			ps = con.prepareStatement("select * from Operator where firstname= "+"'"+operatorName+"'");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Operator operator = new Operator();
				
				operator.setFirstName(rs.getString("firstName"));
				operator.setLastName(rs.getString("lastName"));
				operator.setPhoneNumber(rs.getString("phonenumber"));
				operator.setEmailAddress(rs.getString("emailid"));
				operator.setCreationDate(rs.getDate("creationDate"));
				operator.setMaxNoCustomers(rs.getInt("mcm"));
				operator.setShiftTimeStart(rs.getDate("sts"));
				operator.setShiftTimeEnd(rs.getDate("ste"));
				
				
				operators.add(operator);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operators;
	}
}