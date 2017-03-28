<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<t:layout title="View Operator">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
	
		<header>
			<div class="page-header">
		  		<h1>View Operator<small> Operator Management</small></h1>
			</div>	
		</header>
		
		<div class="row">
			<table class="table table-bordered" >
			   <thead class="thead-default">
			      <tr>
			         <th>First Name</th>
			         <th>Last Name</th>
			         <th>Phone Number</th>
			         <th>Action</th>
			      </tr>
			   </thead>
			   <c:forEach items="${operators}" var="operator">
			      <tbody>
			         <tr>
			            <td>
			               <span class="badge">${operator.firstName}</span>
			            </td>
			            <td>
			               <span class="badge">${operator.lastName}</span>
			            </td>
			            <td>
			               <span class="badge">${operator.phoneNumber}</span>
			            </td>
			            <td>
			               <a class="btn btn-sm btn-primary" href="customer?action=update&id=${operator.userId}" role="button">Update</a>
			               <a class="btn btn-sm btn-danger" href="customer?action=delete&id=${operator.userId}" role="button">Delete</a>
			            </td>
			         </tr>
			      </tbody>
			   </c:forEach>
			</table>
      </div>
			
	<!-- END -->
	</jsp:attribute>
 
</t:layout>