<%--
  Created by IntelliJ IDEA.
  User: jstolorz
  Date: 30.01.19
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanks</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Order your food</h2>
Thank you - your order has been received. You need to pay
 <fmt:formatNumber value="${total}" type="currency" currencyCode="${currency}"/>

<jsp:include page="footer.jsp"/>

</body>
</html>
