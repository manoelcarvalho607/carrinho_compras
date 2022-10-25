function addValue() {
	let valor = frmProduto.valor.value
	let quantidade = frmProduto.quantidade.value
	
	let result = parseFloat(valor) * parseInt(quantidade);
	document.querySelector(".result").innerHTML = result;
	alert(result)
	document.querySelector("[name='total']").value = result;
}