<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  <h2>Menu:</h2>

  <ul>

    <c:forEach items="${menuItems}" var="menuItem">
      <c:if test="${menuItem.price <= 10}">
         <li>${menuItem} - ${menuItem.description}</li>
      </c:if>
    </c:forEach>

  </ul>


 <jsp:include page="footer.jsp"/>
  </body>
</html>
