<%-- 
    Document   : index
    Created on : Aug 20, 2020, 12:01:15 AM
    Author     : Vinicio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msj = (String) request.getAttribute("mensaje");
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

</body>
<h1>Aqui lo que es del usuario</h1>
</html>
