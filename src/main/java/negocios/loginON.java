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
            List<Usuario> usuarios = conUsuario.leeTodos();
            String correo = request.getParameter("correo");
            String contrasenia = request.getParameter("contra");
            if (correo.equals("admin@admin.com") & contrasenia.equals("admin")) {
                request.setAttribute("usuarios", usuarios);
                request.setAttribute("mensaje", "Entra como administrador ROOT");
                request.getRequestDispatcher("/registrosUsuarios.jsp").forward(request, response);
            } else {
                System.out.println(correo + " <<>> " + contrasenia);
                Usuario res = conUsuario.login(correo, contrasenia);
                if (res != null) {
                    if (res.getRol().equals("ADMINISTRADOR")) {
                        request.setAttribute("usuarios", usuarios);
                        request.setAttribute("mensaje", "ADMINISTRADOR");
                        request.getRequestDispatcher("/registrosUsuarios.jsp").forward(request, response);
                    } else {
                        System.out.println("Entrado como usuario");
                        request.getRequestDispatcher("/usuario.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensaje", "Datos Icorrectos");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }

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
