package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.dao.CustomerDao;
import com.service.CustomerService;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CustomerService service = new CustomerService();
		String customerIdStr;
		Integer customerId;
		CustomerDao customerdao=new CustomerDao();
		Customer customer=new Customer();
		
		String action = request.getParameter("action");
		switch (action) {
		case "getAllCustomers":
			try {
				List<Customer> customers = service.getAllCustomer();
				System.out.println("size= "+customers.size());
				
				request.setAttribute("customers", customers);
				
				System.out.println("get all customer");
				

//				request.getRequestDispatcher("viewCustomer.jsp").forward(request, response);
//				request.getRequestDispatcher("SearchAndDisplay.jsp").forward(request, response);
//
//				request.getRequestDispatcher("update.jsp").forward(request, response);

//				request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
				request.getRequestDispatcher("SearchAndDisplay.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "getCustomerByName":
			try {

				String customerNameStr = request.getParameter("customerName");
//				String customerNameStr= "yangyang";
				System.out.println(customerNameStr);
				List<Customer> customers = service.getCustomerByName(customerNameStr);

//				String customerName = request.getParameter("customerName");
				//String customerName= "aa";
				 customers = service.getCustomerByName(customerNameStr);

//				logger.info("getCustomerByName: " + request.getParameter("customerName"));
				
//				customerName = request.getParameter("customerName");
//				
//				customers = service.getCustomerByName(customerName);

				
				System.out.println("size= "+customers.size());
				
				request.setAttribute("customers", customers);
				
//				System.out.println("get customer by name");

//				request.getRequestDispatcher("viewCustomer.jsp").forward(request, response);
				


//				request.getRequestDispatcher("searchCustomer.jsp").forward(request, response);
//
//				request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);

				request.getRequestDispatcher("displayCustomer.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
			
		case "update":
			System.out.println("update come");
			customerIdStr = request.getParameter("id");
			customerId=Integer.parseInt(customerIdStr);
			System.out.println("customerid= "+customerId);
			customer.setFirstName("huozhe");
			customerdao.updateCustomer(customer, customerId);
			break;
			
		case "delete":
			customerIdStr = request.getParameter("id");
			customerId=Integer.parseInt(customerIdStr);
			System.out.println("customerid="+customerId);
			
//			customerdao.updateCustomer(customer, customerId);
			customerdao.deleteCustomer(customerId);
//			logger.info("CustomerID: " + customerId);
//			logger.info("CustomerID: " + customerId);
			break;
		default:
			break;
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("test do post");
	
	}

}
