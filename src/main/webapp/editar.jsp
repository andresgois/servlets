<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="model.Contato" %>
   
   <%
   	Contato contato = (Contato) request.getAttribute("contato");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/phone.png" />
<link rel="stylesheet" href="style.css" />
</head>
<body>

	<h1>Editar contato</h1>
	
	<form name="frmContato" action="update?id=<%=contato.getIdCon()%>">
		<table>
			<tr>
				<td><input type="text" name="idcon"
					placeholder="idcon" class="cx3" readonly="readonly"
					value="<%out.print(contato.getIdCon());%>" /></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" placeholder="nome" class="cx" 
					value="<%out.print(contato.getNome());%>"/></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" placeholder="fone" class="cx2" 
					value="<%out.print(contato.getPhone());%>"/></td>
			</tr>
			<tr>
				<td><input type="text" name="email" placeholder="email" class="cx" 
					value="<%out.print(contato.getEmail());%>" /></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="btn" onclick="validar()"/>
	</form>
	
	<script src="scripts/validador.js" ></script>
</body>
</html>