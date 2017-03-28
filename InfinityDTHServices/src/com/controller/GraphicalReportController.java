package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Graph;
import com.service.GraphicalReportService;

/**
 * Servlet implementation class GraphicalReportController
 */
//@WebServlet("/GraphicalReportController")
public class GraphicalReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(LoginController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GraphicalReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.isUserInRole("admin"))
		{
			logger.info("Non admin user tried to generate report");
			return;
		}
		
		GraphicalReportService service = new GraphicalReportService();
		
		String type = request.getParameter("graphtype");
		String target = request.getParameter("graphtarget");
		
		
		try 
		{
			ArrayList<Graph> data = service.getData(type, target);
			//response.setAttribute("data", data);
		} 
		catch (ClassNotFoundException e) 
		{	
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
	}

}
