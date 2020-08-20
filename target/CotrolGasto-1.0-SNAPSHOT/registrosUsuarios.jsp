<%-- 
    Document   : admin
    Created on : Aug 20, 2020, 12:57:24 AM
    Author     : Vinicio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </div>
</body>
</html>
