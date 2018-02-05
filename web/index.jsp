<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.facemash.PictureForm" %>
<%@ page import="com.facemash.Database" %><%--
  Created by IntelliJ IDEA.
  User: karinazajnullina
  Date: 15.12.2017
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="resources/jquery-3.2.1.js"></script>
    <script src="resources/jsfiles/firstjs.js"></script>
    <style>
        img:hover {
            border: 3px solid #f21b1f; /* Рамка при наведении на ссылку курсора мыши */
        }
    </style>
</head>
<body>
<div>

    <%
        Database database = new Database();
        try {
            List<PictureForm> list = database.getlist();
    %>
    <figure>
        <div align="center" style="margin-top: 200px"><% {
        %>
            <img class="pict0" id='firstpic' src="<%=list.get(0).getWay()%>" data-id="<%=list.get(0).getId()%>"
                 width="550px" height="auto">
            <img class="pict1" id='secondpic' src="<%=list.get(1).getWay()%>" data-id="<%=list.get(1).getId()%>"
                 width="550px" height="auto">
            <%
                }%></div>
    </figure>
    <%
        } catch (SQLException e) {
            e.printStackTrace();
        }


    %>
</div>
</body>
</html>
