<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 
<t:layout title="Admin Page">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		<link href="css/styles.css" rel="stylesheet">
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
	
		<div class="jumbotron text-center">
		   <h1>Welcome Admin</h1>
		   <!--  <p>Resize this responsive page to see the effect!</p> -->
		</div>
		<div class="container">
		   <div class="row">
		      <div class="col-sm-4">
		         <h3>Customer Management</h3>
<<<<<<< .mine
		         <p><a href="customer.jsp">Create Customer</a></p>
		         <p>Update/Search Customer</p>
||||||| .r212
		         <p><a href="CustomerController">Create Customer</a></p>
		         <p>Update/Search Customer</p>
=======
		         <p><a href="customer.jsp">Create Customer</a></p>
		         <p><a href="searchCustomer.jsp">Search Customer</a></p>
>>>>>>> .r231
		      </div>
		      <div class="col-sm-4">
		         <h3>Operator Management</h3>
		         <p><a href="operator.jsp">Create Operator</a></p>
		         <p>Update/Search Operator</p>
		      </div>
		      <div class="col-sm-4">
		         <h3>Retailer Management</h3>
		         <p><a href="retailer.jsp">Create Retailer</a></p>
		         <p>Update/Search Retailer</p>
		      </div>
		   </div>
		</div>
			
	<!-- END -->
	</jsp:attribute>
 
</t:layout>