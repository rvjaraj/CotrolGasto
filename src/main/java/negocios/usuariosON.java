/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import controlador.controladorUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

/**
 *
 * @author Vinicio
 */
@WebServlet(name = "usuariosON", urlPatterns = {"/usuariosON"})
public class usuariosON extends HttpServlet {
    private controladorUsuario conUsuario = new controladorUsuario();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sex = request.getParameter("sexo");
            int sexo = 0;
            if(sex.equals("Femenino")){
                sexo = 1;
            }else{
                sexo = 2;
            }
            String correo = request.getParameter("correo");
            String contrasenia = request.getParameter("contra");
            String rol = request.getParameter("rol");
            Usuario u = new Usuario(nombre, edad, sexo, contrasenia, correo, rol);
            System.out.println(u.toString());
            if(conUsuario.ingresar(u)){
                request.getRequestDispatcher("/registrosUsuarios.jsp").forward(request, response);
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
