/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import controlador.ControladorCategoria;
import controlador.ControladorUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.Usuario;

/**
 *
 * @author Vinicio
 */
@WebServlet(name = "clientesON", urlPatterns = {"/clientesON"})
public class clientesON extends HttpServlet {

    private ControladorUsuario conUsuario = new ControladorUsuario();
    private ControladorCategoria conCategoria = new ControladorCategoria();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String tipo = request.getParameter("tipo");
            if (tipo.equals("actualizarsaldo")) {
                int id = Integer.parseInt(request.getParameter("id"));
                double saldo = Double.parseDouble(request.getParameter("saldo"));
                if (conUsuario.actualizarSaldo(saldo, id)) {
                    request.setAttribute("mensaje", "Saldo Actualizado");
                    Usuario u = conUsuario.buscarID(id);
                    request.setAttribute("usuario", u);
                } else {
                    request.setAttribute("mensaje", "Error al Actualizar Saldo");
                }
                request.getRequestDispatcher("/usuario.jsp").forward(request, response);
            } else if (tipo.equals("regreso")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Usuario u = conUsuario.buscarID(id);
                request.setAttribute("usuario", u);
                request.getRequestDispatcher("/usuario.jsp").forward(request, response);
            } else if (tipo.equals("categoria")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Usuario u = conUsuario.buscarID(id);
                request.setAttribute("usuario", u);
                request.getRequestDispatcher("/categoria.jsp").forward(request, response);
            } else if (tipo.equals("crearcategorias")) {
                int id = Integer.parseInt(request.getParameter("id"));

                String descripcion = request.getParameter("descripcion");
                String tip = request.getParameter("tip");
                System.out.println(tip);
                int ti = 0;
                if(tip.equals("INGRESOS")){
                    ti = 1;
                }else{
                    ti = 2;
                }
                int estado = 2;
                Categoria c = new Categoria(id, descripcion, ti, estado);
                if(conCategoria.ingresar(c)){
                    request.setAttribute("mensaje", "Ingresar categoria correctamente");
                }else{
                    request.setAttribute("mensaje", "Error al ingresar categoria");
                }
                Usuario u = conUsuario.buscarID(id);
                request.setAttribute("usuario", u);
                request.getRequestDispatcher("/categoria.jsp").forward(request, response);
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
