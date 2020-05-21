/**
 * 
 */



function comprobarContrasenya(){

	
	var contra=document.getElementById('contrasenya');
	var contraRep=document.getElementById('contrasenyaRepe');
	var mensaje='Mensaje por defecto.';
	var retorno=false;
	if(contra.value==contraRep.value){
		mensaje='Contraseña válida.';
		contra.classList.remove("border-danger");
		contraRep.classList.remove("border-danger");
		retorno=true;
	}else{
		mensaje='Contraseña no válida.';
		contra.classList.add("border-danger");
		contraRep.classList.add("border-danger");
		retorno=false;
	}
	return  retorno;
}


function envio(){			
	
	
	var permitir=true;
	if(comprobarContrasenya()){
		permitir=true;
	}else{
		permitir=false;
	}

	return permitir;
}

window.onload= function(){
	
	
	document.getElementById('contrasenya').onblur=comprobarContrasenya;
	document.getElementById('contrasenyaRepe').onblur=comprobarContrasenya;
	
}



