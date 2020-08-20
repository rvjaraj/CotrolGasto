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
        <meta charset="UTF-8"/>
        <link href="templete/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="templete/css/toast.css" rel="stylesheet" type="text/css"/>
        <link href="templete/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
    </head>

    <body style="background: #4CA1AF;  /* fallback for old browsers */
          background: -webkit-linear-gradient(to right, #4CA1AF, #4CA1AF);  /* Chrome 10-25, Safari 5.1-6 */
          background: linear-gradient(to right, #4CA1AF, #4CA1AF); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
          ">


        <div class="row">
            <div class="col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h5 class="card-title text-center">Iniciar sesión</h5>
                        <form action="loginON" method="post">
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user">Correo</i></span>
                                </div>
                                <input type="email" name="correo" value="" class="form-control" placeholder="correo"/>

                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key">Password</i></span>
                                </div>
                                <input type="password" value="" name="contra"  class="form-control" placeholder="password"/>
                            </div>
                            <div class="input-group form-group col-md-4 mx-auto">
                                <button type="reset" class="btn btn-outline-info">LIMPIAR</button>
                                <button type="submit" class="btn btn-outline-primary">LOGIN</button>
                            </div>
                            <%
                                 if (msj != null) { %>
                            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                                <strong> <% out.print(msj); %> </strong>                     
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <%}%>
                        </form>
                    </div>
                </div>
            </div>
        </div>





        <script src="templete/js/jquery-3.3.1.slim.min.js"></script>
        <script src="templete/js/jquery-1.11.2.js" type="text/javascript"></script>
        <script src="templete/js/jquery-ui.js" type="text/javascript" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js" type="text/javascript"></script>
        <script src="templete/js/bootstrap.js" type="text/javascript" ></script>


    </body>

</html>
