<%-- 
    Document   : index
    Created on : Nov 8, 2013, 11:13:12 PM
    Author     : komanda.phanzu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="top.jspf" %>
<form data-bind="submit: create" method="post">
	<fieldset>
		<div>
		<label>Id</label>
		<input name="id" data-bind="value: selected.id"/>
		</div>
		<div>
		<label>first Name</label>
		<input name="firstName" data-bind="value: selected.firstName"/>
		</div>
		<div>
		<label>last Name</label>
		<input name="lastName" data-bind="value: selected.lastName"/>
		</div>
		<div>
		<label>email</label>
		<input name="email" data-bind="value: selected.email"/>
		</div>
		<div>
		<label>number Of Points</label>
		<input name="numberOfPoints" data-bind="value: selected.numberOfPoints"/>
		</div>
		
		<div>
				<button id="save">Save</button>
		</div>
		
	</fieldset>
	
</form>
<table border="1" width="100%">
	<thead>
		<tr>
			<th>id</th>
			<th width="25%">firstName</th>
			<th width="25%">lastName</th>
			<th width="25%">email</th>
			<th width="20%">numberOfPoints</th>
		</tr>
	</thead>
	<tbody data-bind="foreach: items">
		<tr>
			<td nowrap="nowrap" data-bind="text: id"></td>
			<td nowrap="nowrap" data-bind="text: firstName"></td>
			<td nowrap="nowrap" data-bind="text: lastName"></td>
			<td nowrap="nowrap" data-bind="text: email"></td>
			<td nowrap="nowrap" data-bind="text: numberOfPoints"></td>
		</tr>    
	</tbody>	
</table>

<script type="text/javascript" src="player.js"></script>
<script type="text/javascript">
	<!--
	var viewModel=new ViewModel();
	viewModel.load();
	ko.applyBindings(viewModel);
	-->
</script>
<%@include file="bottom.jspf" %>