<%-- 
    Document   : unknownView
    Created on : 15 mar 2022, 18:44:38
    Author     : santa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String command = (String) request.getAttribute("parameter");
            out.println(
            "<h1> El comando que ha introducido no existe " + command + " </h1>"
            );
            out.println("<form>" + 
                    "<input type=\"button\" value=\"Retroceder\" onclick=\"location.href = 'index.html'\">" +
                    "</form>");
        %>
    </body>
</html>
