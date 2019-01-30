<%@ page import="java.util.List" %>
<%@ page import="org.bluesoft.domain.MenuItem" %><%--
  Created by IntelliJ IDEA.
  User: jstolorz
  Date: 30.01.19
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Result</title>
</head>
<body>
  <jsp:include page="header.jsp"/>

  <h2>Your search result:</h2>

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
