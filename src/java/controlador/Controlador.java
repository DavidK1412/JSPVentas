/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.EmpleadoDAO;
import modelo.dto.EmpleadoDTO;

/**
 *
 * @author DAVID
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String action = request.getParameter("accion");
        if (menu.equals("Principal")){
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
        if(menu.equals("Empleados")){
            EmpleadoDTO eDto = new EmpleadoDTO();
            EmpleadoDAO eDao = new EmpleadoDAO();
            switch(action){
                case "Listar":
                    ArrayList<EmpleadoDTO> lista = new ArrayList<EmpleadoDTO>();
                    lista = eDao.listAll();
                    request.setAttribute("empleados", lista);
                    break;
                case "Crear":
                    String usuario = request.getParameter("txtUsuario");
                    String nombres = request.getParameter("txtNombres");
                    String apellidos = request.getParameter("txtApellidos");
                    String telefono = request.getParameter("txtTelefono");
                    String pass = request.getParameter("txtPassword");
                    int estado = Integer.parseInt(request.getParameter("txtEstado"));
                    eDto.setUsuario(usuario);
                    eDto.setNombres(nombres);
                    eDto.setApellidos(apellidos);
                    eDto.setTelefono(telefono);
                    eDto.setPassword(pass);
                    eDto.setEstado(estado);
                    eDao.create(eDto);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if(menu.equals("Productos")){
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if(menu.equals("Clientes")){
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
        if(menu.equals("Ventas")){
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
