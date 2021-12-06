<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>

<%@page import="java.util.*"%>
<%@page import="com.obiokolie.Customer"%>
<%@page import="com.obiokolie.SQLControl"%>

<h1>Customer List</h1>

<%
SQLControl control = new SQLControl();
ArrayList<Customer> list = control.selectAllCustomer();

request.setAttribute("list",list);
%>

<!-- <table border="1" width="90%"> -->
<!-- <tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Sex</th><th>Country</th><th>Edit</th><th>Delete</th></tr> -->
<%-- <c:forEach items="${list}" var="u"> --%>
<%-- 	<tr><td>${u.getId()}</td><td>${u.getName()}</td><td>${u.getPassword()}</td><td>${u.getEmail()}</td><td>${u.getSex()}</td><td>${u.getCountry()}</td><td><a href="editform.jsp?id=${u.getId()}">Edit</a></td><td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td></tr> --%>
<%-- </c:forEach> --%>
<!-- </table> -->

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Credit</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <%  if (list != null) {
                        for (int i = 0; i < list.size(); i++) {
                %>
                <tr>
                    <td><%= list.get(i).getcID()%></td>
                    <td><%= list.get(i).getcName()%></td>
                    <td><%= list.get(i).getcCreditBalance()%></td>
                    <td>
                        <a href="editform.jsp?id=<%=list.get(i).getcID()%>">Set Credit</a> 
                    </td>
                </tr>
                <% }
                    }%>
            </tbody>
        </table>




</body>
</html>