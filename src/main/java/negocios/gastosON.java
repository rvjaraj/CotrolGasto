/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import controlador.ControladorCategoria;
import controlador.ControladorTransaccion;
import controlador.ControladorUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.Transaccion;
import modelo.Usuario;

/**
 *
 * @author Vinicio
 */
@WebServlet(name = "gastosON", urlPatterns = {"/gastosON"})
public class gastosON extends HttpServlet {

    private ControladorUsuario conUsuario = new ControladorUsuario();
    private ControladorCategoria conCategoria = new ControladorCategoria();
    private ControladorTransaccion conTransaccion = new ControladorTransaccion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Categoria> listac = conCategoria.leeIngresos();
        PrintWriter out = response.getWriter();
        try {
            String tipo = request.getParameter("tipo");
            if (tipo.equals("gastos")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Usuario u = conUsuario.buscarID(id);
                request.setAttribute("usuario", u);
                request.setAttribute("categorias", listac);
                request.getRequestDispatcher("/gastos.jsp").forward(request, response);
            } else if (tipo.equals("creargasto")) {
                Double valor = Double.parseDouble(request.getParameter("valor"));
                String fecha = request.getParameter("fecha");
                String frecuencia = request.getParameter("frecuencia");
                int categoria = Integer.parseInt(request.getParameter("categoria"));
                int usuario = Integer.parseInt(request.getParameter("id"));

                Transaccion t = new Transaccion(valor, fecha, frecuencia, usuario, categoria);
                if (conTransaccion.ingresar(t)) {
                    request.setAttribute("mensaje", "Gasto Registrado");
                } else {
                    request.setAttribute("mensaje", "Error Registrar gasto");
                }
                Usuario u = conUsuario.buscarID(usuario);
                request.setAttribute("usuario", u);
                request.setAttribute("categorias", listac);
                request.getRequestDispatcher("/gastos.jsp").forward(request, response);

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
