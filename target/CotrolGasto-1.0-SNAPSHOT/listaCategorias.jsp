<%-- 
    Document   : index
    Created on : Aug 20, 2020, 12:01:15 AM
    Author     : Vinicio
--%>

<%@page import="modelo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msj = (String) request.getAttribute("mensaje");
    ArrayList<Categoria> listaCategorias = (ArrayList<Categoria>) request.getAttribute("categorias");
%> 
<!DOCTYPE html>
<html>
    <head>
        <title>Clientes</title>
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

    <div class="col-md-8">
        <table class="table table-striped table-dark">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">DESCRIPCION</th>
                    <th scope="col">TIPO</th>
                    <th scope="col">ESTADO</th>
                </tr>
            </thead>
            <tbody>
                <%
                        if (listaCategorias == null) { %>
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>Lista de vacia</strong>                     
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%} else {
                for (Categoria u : listaCategorias) {
            %>
            <tr valign="rigth">
                <td><%=u.getId()%></td>
                <td><%=u.getDescripcion()%></td>

                <td>
                    <%
                        if (u.getTipo() == 1) {
                            out.print("INGRESOS");
                        } else {
                            out.print("EGRESOS");
                        }
                    %>
                </td>
                <td>
                    <%
                        if (u.getEstado() == 1) {
                    %>
                    <form action="usuariosON" method="post">
                        <input name="tipo" value="Dcategoria" hidden="true">
                        <input name="id" value="<%=u.getId()%>" hidden="true">
                        <input type="submit" class="btn btn-outline-danger" value="DESAPROBAR" />
                    </form>
                    <%
                    } else {
                    %>
                    <form action="usuariosON" method="post">
                        <input name="tipo" value="Acategoria" hidden="true">
                        <input name="id" value="<%=u.getId()%>" hidden="true">
                        <input type="submit" class="btn btn-outline-success" value="APROBAR" />
                    </form>
                    <%
                        }
                    %>
                </td>
            </tr>

            <% }
                    }%>
            </tbody>
        </table>
    </div>


</body>

</html>
