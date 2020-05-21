/**
 * 
 */

function comprobarEdad(){

			var fechaAct=new Date();
			var fechaNac=document.getElementById('fechaNacimiento');
			fechaNac=fechaNac.valueAsDate;
			var diferencia=fechaAct.getYear()-fechaNac.getYear();
			var retorno=true;
			if(diferencia<18){
				document.getElementById('fechaNacimiento').classList.add("border-danger");
				retorno=false;
			}else if(diferencia==18){
				var diferencia2=fechaAct.getMonth()-fechaNac.getMonth();
				if(diferencia2<0){
					document.getElementById('fechaNacimiento').classList.add("border-danger");
					retorno=false;
				}else if(diferencia2==0){
					var diferencia3=fechaAct.getDate()-fechaNac.getDate();
					if(diferencia3<0){
						document.getElementById('fechaNacimiento').classList.add("border-danger");
						retorno=false;
					}else{
						document.getElementById('fechaNacimiento').classList.remove("border-danger");
						retorno=true;
					}
				}else{
					document.getElementById('fechaNacimiento').classList.remove("border-danger");
					retorno=true;
				}

			}else{
				document.getElementById('fechaNacimiento').classList.remove("border-danger");
			}
			return retorno;

		}

function comprobarFechas(){

	var fechaAct=document.getElementById('fechaFinGrado');
	var fechaNac=document.getElementById('fechaInicioGrado');
	fechaNac=fechaNac.valueAsDate;
	fechaAct=fechaAct.valueAsDate;
	
	var diferencia=fechaAct.getYear()-fechaNac.getYear();
	var retorno2=true;
	if(diferencia<0){
		document.getElementById('fechaInicioGrado').classList.add("border-danger");
		document.getElementById('fechaFinGrado').classList.add("border-danger");
		retorno2=false;
	}else if(diferencia==0){
		var diferencia2=fechaAct.getMonth()-fechaNac.getMonth();
		if(diferencia2<0){
			document.getElementById('fechaInicioGrado').classList.add("border-danger");
			document.getElementById('fechaFinGrado').classList.add("border-danger");
			retorno2=false;
		}else if(diferencia2==0){
			var diferencia3=fechaAct.getDate()-fechaNac.getDate();
			if(diferencia3<0){
				document.getElementById('fechaInicioGrado').classList.add("border-danger");
				document.getElementById('fechaFinGrado').classList.add("border-danger");
				retorno2=false;
			}else{
				document.getElementById('fechaInicioGrado').classList.remove("border-danger");
				document.getElementById('fechaFinGrado').classList.remove("border-danger");
				retorno2=true;
			}
		}else{
			document.getElementById('fechaInicioGrado').classList.remove("border-danger");
			document.getElementById('fechaFinGrado').classList.remove("border-danger");
			retorno2=true;
		}

	}else{
		document.getElementById('fechaInicioGrado').classList.remove("border-danger");
		document.getElementById('fechaFinGrado').classList.remove("border-danger");
	}
	return retorno2;

}



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
	
	comprobarEdad();
	var permitir=true;
	if(comprobarEdad()&&comprobarContrasenya()&&comprobarFechas()){
		permitir=true;
	}else{
		permitir=false;
	}

	return permitir;
}

window.onload= function(){
	
	document.getElementById('fechaNacimiento').onblur=comprobarEdad;
	document.getElementById('contrasenyaRepe').onblur=comprobarContrasenya;
	document.getElementById('fechaFinGrado').onblur=comprobarFechas;
	document.getElementById('fechaInicioGrado').onblur=comprobarFechas;
}





















