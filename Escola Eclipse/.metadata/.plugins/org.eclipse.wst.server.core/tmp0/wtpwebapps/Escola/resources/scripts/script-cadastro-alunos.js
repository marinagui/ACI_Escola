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
	var RA = formulario.RA.value; 
	var nome = formulario.nomeAluno.value; 
	var email = formulario.emailAluno.value;
	var telefone = formulario.telefoneAluno.value; 
	var endereco = formulario.enderecoAluno.value; 
	var responsavel = formulario.responsavel.value;
	
	if (RA == "" || nome == "" || telefone == "" || endereco == "" || responsavel == "") {
		alert('Preencha todos os campos'); 
		formulario.RA.focus(); 
		return false; 
	}
	
	/*valida RA*/
	if (isNaN(parseFloat(RA))) {
		alert('RA inválido');
		formulario.RA.focus(); 
		return false; 
	}
   
	/*valida nome*/
    var re = /[a-zA-Z ]*/;
    if (!re.test(nome)) {
       alert('Nome inválido');  
	   return false;
	}

	if (!validacaoEmail(email)) {
		alert('E-mail inválido'); 
		return false;
	}

	if (!validacaoEmail(responsavel)) {
		alert('E-mail do responsável inválido'); 
		return false;
	}


	
	/*valida telefone*/
    telefone = telefone.replace(/D/g,"");
    formulario.telefoneAluno.value = telefone;
	if (isNaN(parseFloat(telefone))) {
       	alert('Telefone inválido');  
	   return false;
	}

	
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
}

function validacaoRA(RA) {
	if (isNaN(parseFloat(RA))) 
		formulario.RA.style.color = 'red';
	else
		formulario.RA.style.color = 'black';
}

