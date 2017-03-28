<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<t:layout title="View Customer">
 
 	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		
	</jsp:attribute>
	 
	<jsp:attribute name="body">
	<!-- START -->
		
		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
		  <h2>Samples</h2>
		  <c:forEach items="${customers}" var="customer">
		    <ul class="list-group">
		      <li class="list-group-item">
		      	<span class="badge">${customer.firstName}</span>
		      	First Name
		      </li>
		      <li class="list-group-item">
		      	<span class="badge">${customer.lastName}</span>
		      	Last Name
		      </li>
		      <li>
			     <a class="btn btn-sm btn-primary" href="customer?action=update&id=${customer.userId}" role="button">Update</a>
			     <a class="btn btn-sm btn-danger" href="customer?action=delete&id=${customer.userId}" role="button">Delete</a>
			  </li>
		    </ul>
		  </c:forEach>
		</div>
	<!-- END -->
	</jsp:attribute>
	
</t:layout>