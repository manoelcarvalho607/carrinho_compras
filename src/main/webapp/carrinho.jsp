<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<JavaBeans> list = (ArrayList<JavaBeans>)
	request.getAttribute("productos");

%>
<!DOCTYPE html >
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Carrinho de compras</title>
<link rel="icon" href="img/carrinho.png">
<link rel="stylesheet" href="css/style2.css">
</head>
<body>
	<div class="container">
		<div class="box2">
			<a href="novo.html" class="botao2">Adicionar produto</a>
			<h1 class="titulo">Carrinho de compras</h1>
			<table id="tabela">
				<thead>
					<tr>
						<th>Id</th>
						<th>Produto</th>
						<th>Valor</th>
						<th>Quantidade</th>
						<th>Total</th>
						<th>Opções</th>
					</tr>
				</thead>
					<tbody>
						<%for (int i =0; i < list.size(); i++) { %>
							<tr>
								<td><%= list.get(i).getIdProd()%></td>
								<td><%= list.get(i).getNomeProd()%></td>
								<td><%= list.get(i).getValorProd()%></td>
								<td><%= list.get(i).getQuantidade()%></td>
								<td><%= list.get(i).getTotal()%></td>
								<td><a href="select?idProd=<%=list.get(i).getIdProd()%>" class="botao1">Editar</a>
								<a href="javascript: confirmStart(<%=list.get(i).getIdProd()%>) " class="botao3">Excluir</a></td>
							</tr>
						
						
						<%} %>
					</tbody>
			</table>
			
			
		</div>
	</div>
	<script src="scripts/confirm.js"></script>
</body>
</html>