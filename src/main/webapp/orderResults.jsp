<%@ page import="java.util.List" %>
<%@ page import="org.bluesoft.domain.MenuItem" %><%--
  Created by IntelliJ IDEA.
  User: jstolorz
  Date: 30.01.19
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Order your food</h2>

<form action='orderReceived.html' method='POST'>
    <ul>
      <%
          List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
          for(MenuItem menuItem: menuItems){
      %>
        <li> <%=menuItem%> <input type='text' name='item_<%=menuItem.getId()%>'/> </li>

      <%
        }
      %>

        <input type='submit'/>
    </ul>

<jsp:include page="footer.jsp"/>
</body>
</html>
