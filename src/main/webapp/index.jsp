<%@ page import="org.bluesoft.domain.MenuItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jstolorz
  Date: 22.01.19
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <head>
    <title>Ricky's Restaurant</title>
  </head>
  <body>

  <jsp:include page="header.jsp"/>
  <ul>
    <%
      List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
      for(MenuItem menuItem: menuItems){
    %>
    <li><%=menuItem%></li>
    <%
      }
    %>
  </ul>


 <jsp:include page="footer.jsp"/>
  </body>
</html>
