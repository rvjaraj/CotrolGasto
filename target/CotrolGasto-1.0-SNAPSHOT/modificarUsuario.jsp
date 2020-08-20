<%-- 
    Document   : index
    Created on : Aug 20, 2020, 12:01:15 AM
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
        <jsp:include page="cabeceraAdmin.jsp" />
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
                <h5 class="card-title text-center">Actualizar Datos</h5>
                <form action="usuariosON" method="post"><br></br>
                    <input name="tipo" value="actualizar" hidden="true">
                    <input name="id" value="<% out.print(usr.getId());%>" hidden="true">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Nombre</i></span>
                        </div>
                        <input type="text" value="<% out.print(usr.getNombre());%>" name="nombre" class="form-control" />
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Edad</i></span>
                        </div>
                        <input type="number" value="<% out.print(usr.getEdad());%>" name="edad" class="form-control" />
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Sexo</i></span>
                        </div>
                        <select class="form-control form-control"  name="sexo">
                            <%
                                if (usr.getSexo() == 1) {
                            %>
                            <option>Masculino</option>
                            <option selected="true">Femenino</option>
                            <% } else {
                            %>
                            <option selected="true">Masculino</option>
                            <option>Femenino</option>
                            <%
                                }
                            %>

                        </select>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Rol</i></span>
                        </div>
                        <select class="form-control form-control" name="rol">
                            <%
                                if (usr.getRol().equals("USUARIO")) {
                            %>
                            <option>ADMINISTRADOR</option>
                            <option selected="true">USUARIO</option>
                            <% } else {
                            %>
                            <option selected="true">ADMINISTRADOR</option>
                            <option >USUARIO</option>
                            <%
                                }
                            %>

                        </select>
                    </div>

                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Correo</i></span>
                        </div>
                        <input type="email" value="<% out.print(usr.getCorreo());%>" name="correo" class="form-control" />
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Contraseña</i></span>
                        </div>
                        <input type="password" value="<% out.print(usr.getContrasenia());%>" name="contra" class="form-control" />
                    </div>
                    <input type="button" value="CANCELAR" onClick="history.go(-1);" class="btn btn-outline-info"/>
                    <button type="submit" class="btn btn-outline-primary">ACTUALIZAR</button>
                </form>
            </div>
        </div>
    </div>p
</body>
</html>
