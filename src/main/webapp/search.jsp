<%--
  Created by IntelliJ IDEA.
  User: jstolorz
  Date: 22.01.19
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ricky's Restaurant - find your favourite dish</title>
</head>
<body>
  <h1>Ricky's Restaurant</h1>
  <h2>Find yout favourite dish</h2>
  <form action="/searchResults.html" method="get">
    Find all dishes containing : <input type="text" name="searchTerm" id="searchTerm"/>
      <input type="submit" value="search"/>
  </form>
</body>
</html>
