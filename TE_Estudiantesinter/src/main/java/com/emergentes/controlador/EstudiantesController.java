package com.emergentes.controlador;

import com.emergente.modelo.Estudiante;
import com.emergentes.dao.EstudianteDAOimpl;
import com.emergentes.dao.EstudiantesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstudiantesController", urlPatterns = {"/EstudiantesController"})
public class EstudiantesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EstudiantesDAO dao = new EstudianteDAOimpl();
        Estudiante es = new Estudiante();
        int id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("estudiante", es);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "edit":
                //Avisocontrolleer
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    //obtenener el objeto correspondiente al registro
                    es = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("error al obtener el registro" + ex.getMessage());
                }

                //colocar como atributo'
                request.setAttribute("estudiante", es);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);

                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("error eliminar" + ex.getMessage());
                }

                response.sendRedirect("EstudiantesController");

                break;

            case "view":
                List<Estudiante> lista = new ArrayList<Estudiante>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("error al listar" + ex.getMessage());
                }
                request.setAttribute("estudiante", lista);
                request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
                break;
            default:
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String seminario = request.getParameter("seminario");
        int confirmado = Integer.parseInt(request.getParameter("confirmado"));

        String fecha = request.getParameter("fecha");
        Estudiante es = new Estudiante();

        es.setId(id);
        es.setNombre(nombre);
        es.setApellido(apellido);
        es.setSeminario(seminario);
        es.setConfirmado(confirmado);
        es.setFecha(fecha);

        EstudiantesDAO dao = new EstudianteDAOimpl();
        if (id == 0) {
            try {
                dao.insert(es);
            } catch (Exception ex) {
                System.out.println("error al sistema" + ex.getMessage());
            }
        } else {
            try {
                dao.update(es);
            } catch (Exception ex) {
                System.out.println("error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("EstudiantesController");

    }
}
