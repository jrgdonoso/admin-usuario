$(document).ready(function() {



});


//Registrar usuario
async function registrarUsuario(){

    datos={};
    datos.nombre=document.querySelector('#exampleFirstName').value;
    datos.apellido=document.querySelector('#exampleLastName').value;
    datos.email=document.querySelector('#exampleInputEmail').value;
    datos.telefono=document.querySelector('#exampleInputPhone').value;
    datos.password=document.querySelector('#exampleInputPassword').value;
    datos.password2=document.querySelector('#exampleRepeatPassword').value;

    console.log(datos.password+"  v/s  "+datos.password2);

    if( document.querySelector('#exampleInputPassword').value != document.querySelector('#exampleRepeatPassword').value){
        alert('Las contraseñas no coinciden');
        return;
    }

    const request = await fetch('api/usuario',
        {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });
    const usuario = await request.json();

    console.log(usuario);
    console.log(datos);

}
