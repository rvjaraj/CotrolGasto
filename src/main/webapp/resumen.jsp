<%-- 
    Document   : categoria
    Created on : Aug 20, 2020, 6:50:00 PM
    Author     : Vinicio
--%>

<%@page import="modelo.Transaccion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Categoria"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msj = (String) request.getAttribute("mensaje");
    Usuario usr = (Usuario) request.getAttribute("usuario");
    ArrayList<Transaccion> gastos = (ArrayList<Transaccion>) request.getAttribute("gastos");
    ArrayList<Transaccion> ingresos = (ArrayList<Transaccion>) request.getAttribute("ingresos");

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
                <h5 class="card-title text-center">GASTOS</h5>
                <div class="mx-auto">
                    <table class="table table-striped table-info">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">VALOR</th>
                                <th scope="col">FECHA</th>
                                <th scope="col">FRECUENCIA</th>
                                <th scope="col">CATEGORIA</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%
                                if (gastos == null) { %>
                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <strong>Lista de vacia</strong>                     
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <%} else {
                            for (Transaccion u : gastos) {
                        %>
                        <tr valign="rigth">
                            <td><%=u.getId()%></td>
                            <td><%=u.getValor()%></td>
                            <td><%=u.getFecha()%></td>
                            <td><%=u.getFrecuencia()%></td>
                            <td><%=u.getCateogrianame()%></td>
                        </tr>

                        <% }
                            }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
            <div class="card-body">
                <h5 class="card-title text-center">INGRESOS</h5>
                <div class="mx-auto">
                    <table class="table table-striped table-success">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">VALOR</th>
                                <th scope="col">FECHA</th>
                                <th scope="col">FRECUENCIA</th>
                                <th scope="col">CATEGORIA</th>

                            </tr>
                        </thead>
                        <tbody>
                            <%
                                if (ingresos == null) { %>
                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <strong>Lista de vacia</strong>                     
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <%} else {
                            for (Transaccion u : ingresos) {
                        %>
                        <tr valign="rigth">
                            <td><%=u.getId()%></td>
                            <td><%=u.getValor()%></td>
                            <td><%=u.getFecha()%></td>
                            <td><%=u.getFrecuencia()%></td>
                            <td><%=u.getCateogrianame()%></td>
                        </tr>

                        <% }
                            }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
