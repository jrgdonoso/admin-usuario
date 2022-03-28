$(document).ready(function() {



});


//Registrar usuario
async function login(){

    datos={};
    datos.email=document.querySelector('#exampleInputEmail').value;
    datos.password=document.querySelector('#exampleInputPassword').value;


    console.log(datos);
    const request = await fetch('api/login',
        {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });
    const respuesta = await request.text();

    if(respuesta== 'false'){
        alert("Las credenciales son incorrectas")
    }else if( respuesta == 'true' ){
        window.location.href='index.html';
    }

    console.log(respuesta);

}