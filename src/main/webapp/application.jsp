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
		<label>key</label>
		<input name="apiKey" data-bind="value: selected.apiKey"/>
		</div>
		<div>
		<label>secret</label>
		<input name="apiSecret" data-bind="value: selected.apiSecret"/>
		</div>
		<div>
		<label>Name</label>
		<input name="name" data-bind="value: selected.name"/>
		</div>
		<div>
			<label>Description</label>
			<input name="description" data-bind="value: selected.description"/>
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
			<th width="25%">name</th>
			<th width="70%">description</th>
		</tr>
	</thead>
	<tbody data-bind="foreach: items">
		<tr>
			<td nowrap="nowrap" data-bind="text: id"></td>
			<td nowrap="nowrap" data-bind="text: name"></td>
			<td data-bind="text: description"></td>
		</tr>    
	</tbody>	
</table>

<script type="text/javascript" src="application.js"></script>
<script type="text/javascript">
	<!--
	var viewModel=new ViewModel();
	viewModel.load();
	ko.applyBindings(viewModel);
	-->
</script>
<%@include file="bottom.jspf" %>