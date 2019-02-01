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
    <script>
        function updateStatus() {
            var request = new XMLHttpRequest();
            request.onreadystatechange = function () {
                if(this.readyState == 4){
                    var json = JSON.parse(this.responseText);
                    document.getElementById("status").innerText = json.status;
                    document.getElementById("time").innerText = 'Last updated:  ' + json.time;
                }
            };
            request.open("GET","/updateStatus?id=${id}",true);
            request.send();
        }


        window.setInterval(
            function () {
                updateStatus();
            }
            ,2000);
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Order your food</h2>
<p>Thank you - your order has been received. You need to pay</p>

<fmt:formatNumber value="${total}" type="currency" currencyCode="${currency}"/>

<p>The current status of your order is: <span id="status">${status}</span>
  <input type="button" value="refresh status" onclick="updateStatus()"/>
</p>
<p id="time"></p>

<jsp:include page="footer.jsp"/>

</body>
</html>
