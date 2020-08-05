<%@page import="java.util.Iterator"%>
<%@page import="com.usastores.bean.StoreBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

		<table>
			<tr>
				<th>storeId</th>
				<th>storeName</th>
				<th>storeArea</th>
				<th>storeZipcode</th>
				<th>storedistanceInMiles</th>
			</tr>
			<c:forEach items="${ListResponse}" var="storeObj">
			<tr>
				<td>${storeObj.storeId}</td>
				<td>${storeObj.storeName}</td>
				<td>${storeObj.storeArea}</td>
				<td>${storeObj.zipcode}</td>
				<td>${storeObj.distanceInMiles}</td>
			</tr>

			</c:forEach>

		</table>
	</div>

</body>
</html>