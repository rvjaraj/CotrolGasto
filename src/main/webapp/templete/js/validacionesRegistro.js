function confirmarEliminar(form) {
    var r = confirm("Esta seguro de Eliminar al Cliente");
    if (r == true) {
        form.submit();
    }
}
