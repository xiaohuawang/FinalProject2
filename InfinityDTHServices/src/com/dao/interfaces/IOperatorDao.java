package com.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Operator;

public interface IOperatorDao {
	public Integer addOperator(Operator operator) throws SQLException, ClassNotFoundException;

	ArrayList<Operator> getAllOperator();

	List<Operator> getOperatorByName(String operatorName) throws SQLException,
			ClassNotFoundException;
}