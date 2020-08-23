<%-- 
    Document   : categoria
    Created on : Aug 20, 2020, 6:50:00 PM
    Author     : Vinicio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Categoria"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msj = (String) request.getAttribute("mensaje");
    Usuario usr = (Usuario) request.getAttribute("usuario");
    ArrayList<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("categorias");
%> 
<!DOCTYPE html>
<html>
    <head>
    <f:subview id="cabeceraadmin">
        <jsp:include page="cabeceraUsuario.jsp" />
        <%            if (msj != null) { %>
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
                <h5 class="card-title text-center">REGISTRAR GASTOS</h5>
                <form action="gastosON" method="post"><br></br>
                    <input name="id" value="<%out.print(usr.getId());%>" hidden="true">
                    <input name="tipo" value="creargasto" hidden="true">
                    <input name="id" value="<%out.print(usr.getId());%>" hidden="true">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Valor</i></span>
                        </div>
                        <input required  type=number step="0.01" min="0.1" value="" name="valor"  class="form-control" />
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Fecha</i></span>
                        </div>
                        <input required type="date" value="" name="fecha"  class="form-control" />
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Frecuencia</i></span>
                        </div>
                        <select required class="form-control form-control" name="frecuencia">
                            <option>DIARIO</option>
                            <option>SEMANAL</option>
                            <option>QUINCENAL</option>
                            <option>MENSUAL</option>
                        </select>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user">Categoria</i></span>
                        </div>
                        <select required class="form-control form-control" name="categoria">
                            <%for (Categoria categoria : categorias) {
                            %> <option value="<%out.print(categoria.getId());%>">  <%out.print(categoria.getDescripcion());%> </option> 
                            <%}%>
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
