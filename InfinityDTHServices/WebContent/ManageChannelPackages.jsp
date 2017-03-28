<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Manage Channel Packages">

	<jsp:attribute name="head">
		<!-- Add HTML content to page header here i.e. StyleSheets -->
		<link href="css/styles.css" rel="stylesheet">
	</jsp:attribute>

	<jsp:attribute name="body">
	<br>

		<!-- Add HTML content to page body here -->
		<!--3rd input field-->
			<div class="container">
			<div class="row">
			<div class="control-group" id="fields">
			<!-- <label class="control-label" for="field1">Add new Category</label> -->
			<div class="controls">
			<form role="form" autocomplete="off">
			
			<h2>Manage Channel Packages</h2>
			<br>
					
			<!--First input field-->
			<div class="form-group">
			    <label for="inputdefault">Package Name</label>
			    <input class="form-control" id="inputdefault" type="text">
			</div>
			<!--4th input field-->			
			<div class="form-group">
			<label for="inputdefault">Package Charging Type(Paid for FTA)</label>
			<select class="form-control" id="sel1">
		         <option>Paid</option>
		         <option>FTA</option>
			</select>
			</div>

			<!--5th input field-->
			<div class="form-group">
			<label for="sel1">Package Transmission Type</label>
			<select class="form-control" id="sel1">
		         <option>HD</option>
		         <option>Standard</option>
			</select>
			</div>

			<!--6th input field-->
			<div class="form-group">
			<label for="inputdefault">Add Channels</label>
			<div class="checkbox">
			<label><input type="checkbox" value="">Standard</label>
			</div>
			<div class="checkbox">
			<label><input type="checkbox" value="">High Definition</label>
			</div>
			<div class="checkbox">
			<label><input type="checkbox" value="">HD Recorder</label>
			</div>
			<div class="checkbox">
			<label><input type="checkbox" value="">IPTV</label>
			</div>

			<!--7th input field-->
			<div class="form-group">
			<label for="inputdefault">Package Cost</label>
			<input class="form-control" id="inputdefault" type="text">
			</div>

			<!--8th input field-->	
			<!--Add starting date-->
			<div class="container"> 
			<div class="row">
			<label for="sel1">Package Available from Date</label>
			</div>
			
			<div class="row">
			<div class='col-sm-3'>
			<div class="form-group">
			<div class='input-group date' id='datetimepicker1'>
			<input type='date' class="form-control" />		              
			</div>
			</div>
			</div>
			</div>

			<!--9th input field-->		
			<!--Add Ending date-->
			<div class="row">
			<label for="sel1">Package Available to Date</label>
			</div>
			<div class="row">
			<div class='col-sm-3'>
			<div class="form-group">
			<div class='input-group date' id='datetimepicker1'>
			<input type='date' class="form-control" />		              
			</div>
			</div>
			</div>
			</div>
			</div>
			<br>

			<!--10th input field-->
			<label for="sel1">Added by default</label>
			<input id= "Yes" type="radio" name="addByDefault" value="Yes"> <span>Yes</span>
			<input id= "No" type="radio" name="addByDefault" value="No"> <span>No</span><br>
			<br>
			<!--2nd input field-->
			<div class="form-group">
			<label for="sel1">Package Category</label>
			<select class="form-control" id="sel1">
		         <option>Sports</option>
		         <option>News</option>
		         <option>Kids</option>
		         <option>Nature</option>
			</select>
			</div>
			
			<label class="control-label" for="field1">Add new Category</label>
			<div class="entry input-group col-xs-3">
			<input class="form-control" name="fields[]" type="text" placeholder="Type Category" />
			<span class="input-group-btn">
			<button class="btn btn-success btn-add" type="button">
			<span class="glyphicon glyphicon-plus"></span>
			</button>
			</span>
			</div>			
			<small>Press <span class="glyphicon glyphicon-plus gs"></span> to add another category</small>
			</form>
			</div>
			</div>
			</div>
			</div>
			<br>
		
	</jsp:attribute>

</t:layout>