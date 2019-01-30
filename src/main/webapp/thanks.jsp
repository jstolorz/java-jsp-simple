<%--
  Created by IntelliJ IDEA.
  User: jstolorz
  Date: 30.01.19
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanks</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<% Double total = (Double) request.getAttribute("total"); %>
<h2>Order your food</h2>
<p>Thank you - your order has been received. You need to pay $ <%=total%> </p>
<jsp:include page="footer.jsp"/>
</body>
</html>
