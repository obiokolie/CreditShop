<%-- 
    Document   : Report
    Created on : Dec 04, 2021
    Author     : Obinna Okolie
--%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
<%@page import="java.util.*"%>
<%@page import="com.obiokolie.Customer"%>
<%@page import="com.obiokolie.SQLControl"%>

<%
String id=request.getParameter("id");
Customer u = SQLControl.getRecordById(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="EditUser" method="post">
<input type="hidden" name="cID" value="<%=u.getcID() %>"/>
<table>
<tr><td>Name:</td><td><input type="text" name="cName" value="<%= u.getcName()%>"/></td></tr>
<tr><td>Credit Limit:</td><td><input type="text" name="creditlimit" value="<%= u.getcCreditBalance()%>"/></td></tr>

</td></tr>
<tr><td colspan="2"><input type="submit" value="Update Limit"/></td></tr>
</table>
</form>

</body>
</html>