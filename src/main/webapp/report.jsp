<%-- 
    Document   : Report
    Created on : Dec 04, 2021
    Author     : Obinna Okolie
--%>

<%@page import="com.obiokolie.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.obiokolie.SQLControl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <script>
function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("customerTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those that don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>
        <title>Customer Report</title>
    </head>
    <body>
        <%
            SQLControl control = new SQLControl();
            ArrayList<Transaction> arrT = control.selectAllTransaction();

        %>
        <h1>Customer Report</h1>
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Get Report by Customer ID." >
        <table border="1" id="customerTable">
            <thead>
                <tr class="header">
                    <th style="width:10%;">Transaction ID</th>
                    <th style="width:10%;">Product ID</th>
                    <th style="width:20%;">Customer</th>
                    <th style="width:20%;">Order Date</th>
                    <th style="width:100%;">Payment Type</th>
                </tr>
            </thead>
            <tbody>
                <%  if (arrT != null) {
                        for (int i = 0; i < arrT.size(); i++) {
                %>
                <tr>
                    <td><%= arrT.get(i).getOrderID()%></td>
                    <td><%= arrT.get(i).getProductID()%></td>
                    <td><%= arrT.get(i).getCustomerID()%></td>
                    <td><%= arrT.get(i).getOrderDate()%></td>
                    <td><%= arrT.get(i).getPaymentMethod()%></td>
                  
                </tr>
                <% }
                    }%>
            </tbody>
        </table>

        <p><a href="index.html">Home</a></p>

    </body>
</html>
