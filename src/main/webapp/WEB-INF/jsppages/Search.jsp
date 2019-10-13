<%@page import="java.util.Iterator"%>
<%@page import="com.usastores.bean.StoreBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Searching Store</title>
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
				<td><label>Store Id to find the Store:</label></td>
				<td><input type="text" placeholder="Enter Store Id" name="storeId"></td>
			</tr>
			<tr>
			<td><input type="submit" value="Search" name="buttonAction"></td>
			</tr>
		</table>
	</form:form>
	</div>
	
	<div align="center">
	
	<table>
	<tr>
	<th>storeId</th>
	<th>storeName</th>
	<th>storeArea</th>
	<th>storeZipcode</th>
	<th>storedistanceInMiles</th>
	</tr>
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
			<tr>
			<td><%=sb.getStoreId() %></td>
			<td><%=sb.getStoreName() %></td>
			<td><%=sb.getStoreArea() %></td>
			<td><%=sb.getZipcode() %></td>
			<td><%=sb.getDistanceInMiles() %></td>
			</tr>
			
			<% 
			
		}
	}
	
	%>
	
	</table>
	</div>
	
</body>
</html>