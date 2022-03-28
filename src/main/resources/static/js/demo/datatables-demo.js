// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable();
    cargarUsuaurio();



});


//Seleccionar usuarios
async function cargarUsuaurio(){

    const request = await fetch('api/usuarios',
        {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    const listaUsuarios = await request.json();


    let rowUsuario=' ';
    for (let usuario of listaUsuarios) {

            rowUsuario =rowUsuario
                + '<tr>'
                + '<td>' + usuario.id + '</td>'
                + '<td>' + usuario.nombre + ' ' + usuario.apellido + '</td>'
                + '<td>' + usuario.email + '</td>'
                + '<td>' + usuario.telefono + '</td>'
                + '<td>'
                + '<a onclick="deleteById(' + usuario.id + ')"  href="#" class="btn btn-danger btn-circle btn-sm">'
                + '<i class="fas fa-trash"></i>'
                + '</a>'
                + '</td>'
                + '</tr>'

    }
    document.querySelector('#dataTable tbody').outerHTML = rowUsuario;


    console.log(listaUsuarios);

}



//Eliminar usuario
async function deleteById(id){
    if(!confirm("Seguro que desea eliminar al usuario selecionado")) {
        console.log("NO se elimina usuario..."+id);
        return;
    }

    const request = await fetch('api/usuario/'+id,
        {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
   // const result = await request.json();
    //console.log("RESULTADO: "+result)
    console.log("Se elimina usuario..."+id);
    cargarUsuaurio();
}






