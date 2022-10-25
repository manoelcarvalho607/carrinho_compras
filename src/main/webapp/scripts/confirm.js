function confirmStart(idProd){
	let resposta = confirm("Confirma a exclusão deste produto?")
	if (resposta === true){
		//redirecionamento p servlet
		window.location.href = "delete?idProd=" + idProd 
	}
}