<%-- 
    Document   : categoria
    Created on : Aug 20, 2020, 6:50:00 PM
    Author     : Vinicio
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msj = (String) request.getAttribute("mensaje");
    Usuario usr = (Usuario) request.getAttribute("usuario");
%> 
<!DOCTYPE html>
<html>
    <head>
    <f:subview id="cabeceraadmin">
        <jsp:include page="cabeceraUsuario.jsp" />
        <%
            if (msj != null) { %>
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong> <% out.print(msj); %> </strong>                     
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <%}%>
    </f:subview>
</head>
<body>
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
            <div class="card-body">
                <h5 class="card-title text-center">CREAR CATEGORIAS</h5>
                <form action="clientesON" method="post"><br></br>
                    <input name="tipo" value="crearcategorias" hidden="true">
                    <input name="id" value="<%out.print(usr.getId());%>" hidden="true">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Descripcion</i></span>
                        </div>
                        <input type="text" value="" name="descripcion"  class="form-control" />
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Tipo</i></span>
                        </div>
                        <select class="form-control form-control" name="tip">
                            <option>INGRESOS</option>
                            <option>EGRESOS</option>
                        </select>
                    </div>
                    <button type="reset" class="btn btn-outline-info">LIMPIAR</button>
                    <button type="submit" class="btn btn-outline-primary">GUARDAR</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
