<%-- 
    Document   : admin
    Created on : Aug 20, 2020, 12:57:24 AM
    Author     : Vinicio
--%>

<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Usuario> listUsuarios = null;
    listUsuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
%> 
<!DOCTYPE html>
<html>
    <head>
    <f:subview id="cabeceraadmin">
        <jsp:include page="cabeceraAdmin.jsp" />
    </f:subview>
</head>
<body>
    <div class="row">
        <div class="col-md-3">
            <div class="card card-body" >
                <form action="usuariosON" method="post"><br></br>
                    <h5 class="card-title bg-white">CREACION DE USUARIOS</h5>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Nombre</i></span>
                        </div>
                        <input type="text" value="" name="nombre" class="form-control" />
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Edad</i></span>
                        </div>
                        <input type="number" value="" name="edad" class="form-control" />
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Sexo</i></span>
                        </div>
                        <select class="form-control form-control" name="sexo">
                            <option>Masculino</option>
                            <option>Femenino</option>
                        </select>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Rol</i></span>
                        </div>
                        <select class="form-control form-control" name="rol">
                            <option>ADMINISTRADOR</option>
                            <option>USUARIO</option>
                        </select>
                    </div>

                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Correo</i></span>
                        </div>
                        <input type="email" value="" name="correo" class="form-control" />
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Contraseña</i></span>
                        </div>
                        <input type="password" value="" name="contra" class="form-control" />
                    </div>
                    <button type="reset" class="btn btn-outline-info">LIMPIAR</button>
                    <button type="submit" class="btn btn-outline-primary">GUARDAR</button>
                </form>
            </div>
        </div>
        <div class="col-md-8">
            <table class="table table-striped table-dark">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">EDAD</th>
                        <th scope="col">SEXO</th>
                        <th scope="col">CORREO</th>
                        <th scope="col">ROL</th>
                        <th scope="col">SALDO</th>
                        <th scope="col">ELIMINAR</th>
                        <th scope="col">EDITAR</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (listUsuarios == null) { %>
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    <strong>Lista Vacia</strong>                     
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <%} else {
                    for (Usuario u : listUsuarios) {
                %>
                <tr valign="rigth">
                    <td><%=u.getId()%></td>
                    <td><%=u.getNombre()%></td>
                    <td><%=u.getEdad()%></td>
                    <td>
                        <%
                            if (u.getSexo() == 1) {
                                out.print("Femenino");
                            } else {
                                out.print("Masculino");
                            }
                        %>
                    </td>
                    <td><%=u.getCorreo()%></td>
                    <td><%=u.getRol()%></td>
                    <td><%=u.getSaldo()%></td>
                    <td><form>
                            <input name="tipo" value="eliminar" hidden="true">
                            <input name="id" value="<%=u.getId()%>" hidden="true">
                            <button type="submit" class="btn btn-outline-danger">ELIMINAR</button>
                        </form></td>
                    <td><form>
                            <input name="tipo" value="modificar" hidden="true">
                            <input name="id" value="<%=u.getId()%>" hidden="true">
                            <button type="submit" class="btn btn-outline-success">MODIFICAR</button>
                        </form></td>

                </tr>

                <% }
                    }%>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
