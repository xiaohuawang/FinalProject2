package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Operator;
import com.dao.OperatorDao;
import com.dao.interfaces.IOperatorDao;


public class OperatorService {
	
	IOperatorDao dao = new OperatorDao();
		
	public Integer addOperator(Operator operator) throws SQLException, ClassNotFoundException {
		return dao.addOperator(operator);
	}
	
	public List<Operator> getAllOperator() throws SQLException, ClassNotFoundException {
		return dao.getAllOperator();
	}
	
	public List<Operator> getOperatorByName(String operatorName) throws SQLException, ClassNotFoundException {
		return dao.getOperatorByName(operatorName);
	}
}

