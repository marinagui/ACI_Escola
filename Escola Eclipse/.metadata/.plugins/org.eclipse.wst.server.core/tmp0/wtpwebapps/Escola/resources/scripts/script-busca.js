$(document).ready(function () {
	if($(".ra") != null){
	    $(".ra").on('input propertychange paste', function () {
	        mask(this, "99999");
	    });
	    $(".ra").on('focus', function () {
	        mask(this, "99999");
	    });
	}
    if($(".telefone") != null){
	    $(".telefone").on('input propertychange paste', function () {
	        mask(this, "(99)99999-9999");
	    });
	    $(".telefone").on('focus', function () {
	        mask(this, "(99)99999-9999");
	    });
    }
});