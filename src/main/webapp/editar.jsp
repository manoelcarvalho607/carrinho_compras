<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Carrinho de compras</title>
<link rel="icon" href="img/carrinho.png">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<!-- https://www.devmedia.com.br/como-centralizar-divs-em-html-e-css/37568  -->
	<div class="container">
		<div class="box">
			<h1>Editar produtos</h1>
			<form name="frmProduto" action="update" method="post">
				<table>
					<tr>
						<td><input type="text" name="idProd" id="caixa3" readonly
						value="<%out.print(request.getAttribute("idProd"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="nomeProd" class="caixa1"
						value="<%out.print(request.getAttribute("nomeProd"));%>"></td>
					</tr>
					<tr>
						<td><input type="number" step="0.01" min="0.01" name="valor"
							class="caixa1"
							value="<%out.print(request.getAttribute("valor"));%>"></td>

					</tr>
					<tr>
						<td><input type="number" name="quantidade" class="caixa1"
						value="<%out.print(request.getAttribute("quantidade"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="total" class="caixa1"
						value="<%out.print(request.getAttribute("total"));%>"></td>
					</tr>
					

				</table>
				<input type="button" value="Salvar" class="botao1"
					onclick="validar()">
			</form>

		</div>
	</div>

	<script src="scripts/validador.js"></script>

</body>
</html>