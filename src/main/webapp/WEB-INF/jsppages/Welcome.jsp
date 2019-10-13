<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome-page</title>


</head>
<body>
<div align="center">
	<table>
	
					<tr>
						<td>
							<div style="text-align: center;">
								<tr>
								<td><input type="button" value="Create" onclick="location.href='createStore'"> </td>
								<td><input type="button" value="Update" onclick="location.href='updateStore'"> </td>
								<td><input type="button" value="Delete" onclick="location.href='deleteStore'"> </td>
								<td><input type="button" value="Find a Store" onclick="location.href='findStore'"> </td>
									
								</tr>
							</div>
						</td>
					</tr>
				</table>
				</div>
				<div>
				<% Object obj=request.getAttribute("responseObj");
				if(obj!=null)
				{
					String responseMsg=(String)obj;
					out.print(responseMsg);
				}
				
				
				%>
				
				
				</div>
				
				
</body>
</html>