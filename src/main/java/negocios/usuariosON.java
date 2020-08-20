/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import controlador.ControladorUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

    private ControladorUsuario conUsuario = new ControladorUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String tipo = request.getParameter("tipo");
            if (tipo.equals("guardar")) {
                String nombre = request.getParameter("nombre");
                int edad = Integer.parseInt(request.getParameter("edad"));
                String sex = request.getParameter("sexo");
                int sexo = 0;
                if (sex.equals("Femenino")) {
                    sexo = 1;
                } else {
                    sexo = 2;
                }
                String correo = request.getParameter("correo");
                String contrasenia = request.getParameter("contra");
                String rol = request.getParameter("rol");
                Usuario u = new Usuario(nombre, edad, sexo, contrasenia, correo, rol);
                System.out.println(u.toString());
                if (conUsuario.ingresar(u)) {
                    request.setAttribute("mensaje", "Cliente Registrado");
                } else {
                    request.setAttribute("mensaje", "Error al Cliente Registrado");
                }
            } else if (tipo.equals("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                if (conUsuario.borrar(id)) {
                    request.setAttribute("mensaje", "Cliente Borrado");
                } else {
                    request.setAttribute("mensaje", "Error al borrar al Cliente");
                }
            }
            List<Usuario> usuarios = conUsuario.leeTodos();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("/registrosUsuarios.jsp").forward(request, response);

        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }
}
