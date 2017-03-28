package com.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.sql.SQLException;

import com.bean.Graph;
import com.bean.SampleBean;
import com.util.DBConnection;

public class GraphicalReportDao extends GenericDao 
{
	public ArrayList<Graph> getData(String type, String target)
	{
		ArrayList<Graph> data = new ArrayList<Graph>();
		
		// target = {operator, customer, retailer}
		Calendar prevYear = Calendar.getInstance();
	    prevYear.add(Calendar.YEAR, -1);    
	    prevYear.get(Calendar.YEAR);
		long mills = prevYear.getTimeInMillis();
		Date date = new Date(mills);
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		String dateText = df.format(date);
		
		StringBuilder sb = new StringBuilder();
		if (type.equals("bar"))
		{
			sb.append("select to_char(creationdate, 'YYYY-MM') as date, count(*) "
					+ "as count from ? group by to_char(creationdate, 'YYYY-MM') "
					+ "where creationdate > to_date(?, 'yyyy-mm-dd')");
		}
		else
		{
			
		}
		
		con = DBConnection.getConnection();	
		try 
		{
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, target);
			ps.setString(2, dateText);
			rs = ps.executeQuery();		
			
			
			while(rs.next()) 
			{
				Graph point = new Graph();
				point.setName(rs.getString("date"));
				point.setCount(rs.getInt("count"));
				
				data.add(point);
			}
			
			} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		DBConnection.CloseConnection(con);

		if(data.size() > 0) 
		{
			return data;
		}
		
		return null;
	}

}
