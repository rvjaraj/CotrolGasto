<%-- 
    Document   : cabeceraAdmin
    Created on : Aug 20, 2020, 12:46:43 AM
    Author     : Vinicio
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usr = (Usuario) request.getAttribute("usuario");
%>

<!DOCTYPE html>
<html>
    <h:head>
        <meta charset="UTF-8"/>
        <link href="templete/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="templete/css/toast.css" rel="stylesheet" type="text/css"/>
        <link href="templete/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
    </h:head>

    <h:body style="background: #4CA1AF;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #4CA1AF, #4CA1AF);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #4CA1AF, #4CA1AF); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            ">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <form action="clientesON" method="post">
                <input name="tipo" value="regreso" hidden="true">
                <input name="id" value="<%out.print(usr.getId()); %>" hidden="true">
                <input type="submit" class="btn btn-outline-primary" value="MIS DATOS" />
            </form>
            <div class="collapse navbar-collapse" id="navbarNav">
                <form action="clientesON" method="post">
                    <input name="tipo" value="categoria" hidden="true">
                    <input name="id" value="<%out.print(usr.getId());%>" hidden="true">
                    <input type="submit" class="btn btn-outline-secondary" value="GATEGORIA" />
                </form>
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">SALIR<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
        <br>

        <script src="templete/js/jquery-3.3.1.slim.min.js"></script>
        <script src="templete/js/jquery-1.11.2.js" type="text/javascript"></script>
        <script src="templete/js/jquery-ui.js" type="text/javascript" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js" type="text/javascript"></script>
        <script src="templete/js/bootstrap.js" type="text/javascript" ></script>


    </h:body>
</html>
