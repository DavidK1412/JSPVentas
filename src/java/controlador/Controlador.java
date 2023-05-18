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
import modelo.dto.ProductoDTO;
import modelo.dto.ClienteDTO;
import modelo.dao.ClienteDAO;

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
            String id;
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
                case "Editar":
                    id = request.getParameter("id");
                    eDto.setUsuario(id);
                    eDto = eDao.search(eDto);
                    System.out.println(eDto.toString());
                    request.setAttribute("em", eDto);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String usuario1 = request.getParameter("txtUsuario");
                    String nombres1 = request.getParameter("txtNombres");
                    String apellidos1 = request.getParameter("txtApellidos");
                    String telefono1 = request.getParameter("txtTelefono");
                    String pass1 = request.getParameter("txtPassword");
                    int estado1 = Integer.parseInt(request.getParameter("txtEstado"));
                    eDto.setUsuario(usuario1);
                    eDto.setNombres(nombres1);
                    eDto.setApellidos(apellidos1);
                    eDto.setTelefono(telefono1);
                    eDto.setPassword(pass1);
                    eDto.setEstado(estado1);
                    eDao.update(eDto);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    id = request.getParameter("id");
                    eDto.setUsuario(id);
                    eDao.delete(eDto);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if(menu.equals("Productos")){
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if(menu.equals("Clientes")){
            ClienteDTO cDto = new ClienteDTO();
            ClienteDAO cDao = new ClienteDAO();
            String id;
            switch(action){
                case "Listar":
                    ArrayList<ClienteDTO> lista = new ArrayList<ClienteDTO>();
                    lista = cDao.listAll();
                    request.setAttribute("clientes", lista);
                    break;
                case "Crear":
                    String identificacion = request.getParameter("txtIdentificacion");
                    String nombres = request.getParameter("txtNombres");
                    String apellidos = request.getParameter("txtApellidos");
                    String direccion = request.getParameter("txtDireccion");
                    int estado = Integer.parseInt(request.getParameter("txtEstado"));
                    cDto.setIdentificacion(identificacion);
                    cDto.setNombres(nombres);
                    cDto.setApellidos(apellidos);
                    cDto.setDireccion(direccion);
                    cDto.setEstado(estado);
                    cDao.create(cDto);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id = request.getParameter("id");
                    cDto.setIdentificacion(id);
                    cDto = cDao.search(cDto);
                    System.out.println(cDto.toString());
                    request.setAttribute("cl", cDto);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String identificacion1 = request.getParameter("txtIdentificacion");
                    String nombres1 = request.getParameter("txtNombres");
                    String apellidos1 = request.getParameter("txtApellidos");
                    String direccion1 = request.getParameter("txtDireccion");
                    int estado1 = Integer.parseInt(request.getParameter("txtEstado"));
                    cDto.setIdentificacion(identificacion1);
                    cDto.setNombres(nombres1);
                    cDto.setApellidos(apellidos1);
                    cDto.setDireccion(direccion1);
                    cDto.setEstado(estado1);
                    cDao.update(cDto);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    id = request.getParameter("id");
                    cDto.setIdentificacion(id);
                    cDao.delete(cDto);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
            }
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
