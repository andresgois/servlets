<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página JSP</title>
</head>
<body>

	<h2>Hello JSP</h2>
	
	<%out.println("out"); %>
	<%-- Comentátio --%>
	<p>Data <%= new Date() %></p>
	<%! int contador = 0; %>
	<p>Visitas: </p><%= contador++ %>
</body>
</html>