<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
</head>
<body>
<div align="center">
<jsp:include page="Welcome.jsp" />
</div>
<div></div>
<div align="center">
<form:form action="deleteInTable" method="post">
		<table>
			<tr>
				<td><label>Store Id to delete the records:</label></td>
				<td><input type="text" name="storeId"></td>
			</tr>
			<tr>
			<td><input type="submit" value="Delete"></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>