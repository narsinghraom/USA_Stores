<%@page import="java.util.Iterator"%>
<%@page import="com.usastores.bean.StoreBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
<div align="center">
<jsp:include page="Welcome.jsp" />
</div>
<div></div>
<div align="center">
	<form:form action="findAStore" method="post">
		<table>
			<tr>
				<td><label>Enter Store Id:</label></td>
				<td><input type="text" name="storeId"></td>
			</tr>
			<tr>
			<td><input type="submit" value="Fetch" name="buttonAction"></td>
			</tr>
		</table>
	</form:form>
	</div>
	
	<div id="update res" align="center">
	<form action="updateInTable" method="post">
	<%
	Object obj=request.getAttribute("ListResponse");
	if(obj!=null)
	{
		List<StoreBean> listRes=(List)obj;
		
		Iterator itr=listRes.iterator();
		while(itr.hasNext())
		{
			StoreBean sb=(StoreBean)itr.next();
			
			%>
			
			<table>
			<tr>
					<td><label>Store Id:</label></td>
					<td><input type="text" name="storeId" value=<%=sb.getStoreId() %> disabled="disabled"></td>
					<td><input type="hidden" name="storeId" value=<%=sb.getStoreId() %>></td>
				</tr>
			
				<tr>
					<td><label>Store Name:</label></td>
					<td><input type="text" name="storeName" value=<%=sb.getStoreName() %>></td>
				</tr>
				
				<tr>
					<td><label>Store Location:</label></td>
					<td><input type="text" name="storeArea" value=<%= sb.getStoreArea()%>></td>
				</tr>
				<tr>
				<td><label>ZipCode:</label></td>
				<td><input type="text" name="zipcode" value=<%=sb.getZipcode() %>></td>
				
				</tr>
				
				<tr>
					<td><label>Distance in kilometers:</label></td>
					<td><input type="text" name="distanceInMiles" value=<%= sb.getDistanceInMiles()%>></td>
				</tr>
				<tr>
				<td><input type="submit" value="Update"></td>
				<td><input type="reset" value="Reset"></td>
				
				</tr>

			</table>
			
			
			
			<% 
			
		}
	}
	
	%>
	
	
	
	
	</form>
	
	
	</div>
	
	
	
</body>
</html>