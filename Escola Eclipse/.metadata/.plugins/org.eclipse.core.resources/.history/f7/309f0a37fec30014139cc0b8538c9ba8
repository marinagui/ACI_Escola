function validaResponsavel() { 
	var email = formulario.emailResp.value;
	var nome = formulario.nomeResp.value; 
	var telefone = formulario.telefoneResp.value; 
	var endereco = formulario.enderecoResp.value; 

	
	if (nome == "" || telefone == "" || endereco == "") {
		alert('Preencha todos os campos'); 
		formulario.RA.focus(); 
		return false; 
	}
   
	/*valida nome*/
    var re = /^[A-Za-z]+$/;
    if (!re.test(nome)) {
       alert('Nome inválido');  
	   return false;
	}

	/*valida email*/
	if (!validacaoEmail(email)) {
		alert('E-mail inválido'); 
		return false;
	}
	
	/*valida telefone*/
    telefone = telefone.replace(/D/g,"");
    formulario.telefoneAluno.value = telefone;
	if (isNaN(parseFloat(telefone))) {
       	alert('Telefone inválido');  
	   return false;
	}

	return true;
	
}

function validacaoEmail(email) { 
	usuario = email.value.substring(0, email.value.indexOf("@")); 
	dominio = email.value.substring(email.value.indexOf("@")+ 1, email.value.length); 
	if (!((usuario.length >=1) && 
		  (dominio.length >=3) && 
		  (usuario.search("@")==-1) && 
		  (dominio.search("@")==-1) && 
		  (usuario.search(" ")==-1) && 
		  (dominio.search(" ")==-1) && 
		  (dominio.search(".")!=-1) && 
		  (dominio.indexOf(".") >=1) && 
		  (dominio.lastIndexOf(".") < dominio.length - 1))) {  
		return false;
	} 

	return true;
}
