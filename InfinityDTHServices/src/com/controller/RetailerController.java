package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.Address;
import com.bean.Retailer;
import com.service.RetailerService;
import com.util.DBConnection;
import com.util.DateUtil;

/**
 * Servlet implementation class RetailerController
 */
@WebServlet("/RetailerController")
public class RetailerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(DBConnection.class);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetailerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RetailerService service = new RetailerService();
		String action = request.getParameter("action");
		switch(action){
			case "getAllRetailers":
				try{
					List<Retailer> retailers = service.getAllRetailers();
					
					if(retailers == null){
						logger.error("No Retailers Found");
					}
					
					request.setAttribute("retailerList", retailers);
					request.getRequestDispatcher("viewRetailers.jsp").forward(request, response);
					
					for(Retailer retailer: retailers){
						logger.info(retailer.toString());
					}
				}catch (ClassNotFoundException | SQLException e){
					logger.error(e.getMessage());
				}
				break;
			case "getRetailerByName":
				try{
					Retailer retailer = service.getRetailerByName(request.getParameter("name"));
					
					if(retailer == null){
						logger.error("No retailer with such name");
					}
					
					logger.info(retailer.toString());
					
				} catch (ClassNotFoundException | SQLException e){
					logger.error(e.getMessage());
				}
			default:
				break;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RetailerService service = new RetailerService();
		
		Retailer retailer = new Retailer();
		retailer.setName(request.getParameter("name"));
		retailer.setContactNo1(request.getParameter("contactNo1"));
		retailer.setContactNo2(request.getParameter("contactNo2"));
		retailer.setSetTopBoxLimit(Integer.parseInt(request.getParameter("setTopBoxLimit")));
		retailer.setCreditLimit(Double.parseDouble(request.getParameter("creditLimit")));
		retailer.setCommissionPercentage(Double.parseDouble(request.getParameter("commissionPercentage")));
		retailer.setServiceCharges(Double.parseDouble(request.getParameter("serviceCharges")));
		retailer.setRetailerCreationDate(DateUtil.convertStringToDate(request.getParameter("retailerCreationDate"), "MM-dd-yyyy"));
	
		Address address = new Address();
		address.setAddress1(request.getParameter("address1"));
		address.setAddress2(request.getParameter("address2"));
		address.setLandMark(request.getParameter("landmark"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setPinCode(request.getParameter("zipcode"));
		
		retailer.setAddress(address);
	
		try {
			// service will add the sample to db
			Integer userId = service.addRetailer(retailer);
			
			if(userId == -1) {
				logger.error("ERROR ADDING OPERATOR");
				request.getRequestDispatcher("sample.jsp").forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// make sure to log error
			logger.error(e.getMessage());
		}
	}

}
