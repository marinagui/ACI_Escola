$(document).ready(function () {
    $(".telefone").on('input propertychange paste', function () {
        mask(this, "(99)99999-9999");
    });
    $(".telefone").on('focus', function () {
        mask(this, "(99)99999-9999");
    });
});

String.prototype.replaceAll = function(str1, str2, ignore) 
{
	return this.replace(new RegExp(str1.replace(/([\/\,\!\\\^\$\{\}\[\]\(\)\.\*\+\?\|\<\>\-\&])/g,"\\$&"),(ignore?"gi":"g")),(typeof(str2)=="string")?str2.replace(/\$/g,"$$$$"):str2);
}

function validaResponsavel(formulario) { 
	var email = formulario.emailResp.value;
	var nome = formulario.nomeResp.value; 
	var telefone = formulario.telefoneResp.value; 
	var endereco = formulario.enderecoResp.value; 
	var valido = true;
	
	formulario.nomeResp.style.borderColor = "#b9bdc1";
	formulario.emailResp.style.borderColor = "#b9bdc1";
	formulario.enderecoResp.style.borderColor = "#b9bdc1";
	formulario.telefoneResp.style.borderColor = "#b9bdc1";
	
	if (nome == "" || telefone == "" || endereco == "" || email == "") {
		if(nome == "")
			formulario.nomeResp.style.borderColor = "red";
		if(email == "")
			formulario.emailResp.style.borderColor = "red";
		if(endereco == "")
			formulario.enderecoResp.style.borderColor = "red";
		if(telefone == "")
			formulario.telefoneResp.style.borderColor = "red";
		valido = false; 
	}
   
	/*valida nome*/
    var re = /[a-zA-Z ]*/;
    if (!re.test(nome) || nome.length < 4) {
    	formulario.nomeResp.style.borderColor = "red";
    	valido = false; 
	}
    
    

	/*valida email*/
	if (!validacaoEmail(email)) {
		formulario.emailResp.style.borderColor = "red";
		valido = false; 
	}
	
	
	
	/*valida endereco*/
	if(endereco.length<5){
		formulario.enderecoResp.style.borderColor = "red";
		valido = false; 
	}
	
	
	
	/*valida telefone*/
	

    telefone = telefone.replaceAll("(","");
    telefone =  telefone.replaceAll(")","");
    telefone = telefone.replaceAll("-","");
    
    
	if (isNaN(parseFloat(telefone))) {
       formulario.telefoneResp.style.borderColor = "red";
       valido = false; 
	}
	
	if(telefone.length < 10){
		formulario.telefoneResp.style.borderColor = "red";
		valido = false; 
	}
		
	
	
	
	return valido;
	
}

function validacaoEmail(email) { 
	usuario = email.substring(0, email.indexOf("@")); 
	dominio = email.substring(email.indexOf("@")+ 1, email.length); 
	if ((usuario.length >=1) && 
		  (dominio.length >=3) && 
		  (usuario.search("@")==-1) && 
		  (dominio.search("@")==-1) && 
		  (usuario.search(" ")==-1) && 
		  (dominio.search(" ")==-1) && 
		  (dominio.search(".")!=-1) && 
		  (dominio.indexOf(".") >=1) && 
		  (dominio.lastIndexOf(".") < dominio.length - 1)) {  
		return true;
	} 

	return false;
}

