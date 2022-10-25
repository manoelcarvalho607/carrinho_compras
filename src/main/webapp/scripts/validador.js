function validar() {
	let nome = frmProduto.nomeProd.value
	let valor = frmProduto.valor.value
	let quantidade = frmProduto.quantidade.value
	
	let result = parseFloat(valor) * parseInt(quantidade);
	document.querySelector("[name='total']").value = result;
	
	
	if (nome === "") {
		alert('Preecha o campo: nome do produto')
		frmProduto.nomeProd.focus()
		return false
	} else if (valor === "") {
		alert('Preecha o campo: valor do produto')
		frmProduto.valor.focus()
		return false
	} else if (quantidade === "") {
		alert('Preecha o campo: quantidade')
		frmProduto.quantidade.focus()
		return false
	} else {
		document.forms["frmProduto"].submit()
	}
}


