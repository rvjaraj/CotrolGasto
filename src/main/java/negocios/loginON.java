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
import modelo.Usuario;

/**
 *
 * @author Vinicio
 */
@WebServlet(name = "loginON", urlPatterns = {"/loginON"})
public class loginON extends HttpServlet {

    private ControladorUsuario conUsuario = new ControladorUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String correo = request.getParameter("correo");
            String contrasenia = request.getParameter("contra");
            System.out.println(contrasenia + " <> " + correo);
            List<Usuario> usuarios = conUsuario.leeTodos();
            if (usuarios != null) {
                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("/registrosUsuarios.jsp").forward(request, response);
            } else {
                request.setAttribute("usuarios", null);
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
