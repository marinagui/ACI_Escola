$(document).ready(function () {
    $(".ra").on('input propertychange paste', function () {
        mask(this, "99999");
    });
    $(".ra").on('focus', function () {
        mask(this, "99999");
    });
});

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

function validaAluno(formulario) { 
	var RA = formulario.ra.value; 
	var nome = formulario.nomeAluno.value; 
	var email = formulario.emailAluno.value;
	var telefone = formulario.telefoneAluno.value; 
	var endereco = formulario.enderecoAluno.value; 
	var responsavel = formulario.emailResp.value;
	var valido = true;
	
	formulario.ra.style.borderColor = "#b9bdc1";
	formulario.nomeAluno.style.borderColor = "#b9bdc1";
	formulario.emailAluno.style.borderColor = "#b9bdc1";
	formulario.telefoneAluno.style.borderColor = "#b9bdc1";
	formulario.enderecoAluno.style.borderColor = "#b9bdc1";
	formulario.emailResp.style.borderColor = "#b9bdc1";
	
	if (RA == "" || nome == "" || email == "" || telefone == "" || endereco == "" || responsavel == "") {
		if(RA == ""){
			formulario.ra.style.borderColor = "red";
		}
		if(nome == ""){
			formulario.nomeAluno.style.borderColor = "red";
		}
		if(email == ""){
			formulario.emailAluno.style.borderColor = "red";
		}
		if(telefone == ""){
			formulario.telefoneAluno.style.borderColor = "red";
		}
		if(endereco == ""){
			formulario.enderecoAluno.style.borderColor = "red";
		}
		if(responsavel == ""){
			formulario.emailResp.style.borderColor = "red";
		}
		valido = false; 
	}
	
	
	
	/*valida RA*/
	if (isNaN(parseFloat(RA))) {
		formulario.ra.style.borderColor = "red";
		valido = false; 
	}
   
	/*valida nome*/
    var re = /[a-zA-Z ]*/;
    if (!re.test(nome)) {
    	formulario.nomeAluno.style.borderColor = "red";
    	valido = false; 
	}

	if (!validacaoEmail(email)) {
		formulario.emailAluno.style.borderColor = "red";
		valido = false; 
	}

	if (!validacaoEmail(responsavel)) {
		formulario.emailResp.style.borderColor = "red";
		valido = false; 
	}


	
	/*valida telefone*/
	
	

    telefone = telefone.replaceAll("(","");
    telefone =  telefone.replaceAll(")","");
    telefone = telefone.replaceAll("-","");
    
    formulario.telefoneAluno.value = telefone;
	if (isNaN(parseFloat(telefone))) {
		formulario.telefoneAluno.style.borderColor = "red";
		valido = false; 
	}

	return valido
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

