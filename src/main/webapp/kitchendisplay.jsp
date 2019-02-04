<%--
  Created by IntelliJ IDEA.
  User: jstolorz
  Date: 04.02.19
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Live Order</title>
    <script>
        var connectionOpen = false;
        var nextOrder = 1;
        function getOrders() {
            if(!connectionOpen){
                connectionOpen = true;
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                        connectionOpen = false;
                        nextOrder++;
                        var orderDiv = document.getElementById("orders");
                        orderDiv.innerHTML = xmlHttp.responseText + orderDiv.innerHTML;
                    }
                }
                xmlHttp.open("GET","kitchenAsyncServlet?size=" + nextOrder, true);
                xmlHttp.send();
            }
        }

        setInterval(getOrders, 500);
    </script>
</head>
<body>
<h1>Ricky's Restaurant - Live orders</h1>
  <div id="orders"></div>
</body>
</html>
