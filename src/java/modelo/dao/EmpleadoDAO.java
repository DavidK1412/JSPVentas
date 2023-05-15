package modelo.dao;

import interfaces.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.dto.EmpleadoDTO;
import utils.Connector;

public class EmpleadoDAO implements IDao<EmpleadoDTO> {

    
    private static Connector conn = Connector.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public EmpleadoDTO search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<EmpleadoDTO> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(EmpleadoDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(EmpleadoDTO obj, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean create(EmpleadoDTO obj) {
        throw new UnsupportedOperationException();
    }
    
    public EmpleadoDTO logIn(String user, String pass){
        EmpleadoDTO empleado = new EmpleadoDTO();
        String SQL = "SELECT * FROM empleado WHERE Usuario = ? AND password = ?";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                empleado.setUUID(rs.getString("UUID"));
                empleado.setUsuario(rs.getString("Usuario"));
                empleado.setNombres(rs.getString("Nombres"));
                empleado.setApellidos(rs.getString("Apellidos"));
                empleado.setTelefono(rs.getString("Telefono"));
                empleado.setEstado(rs.getInt("Estado"));
                empleado.setPassword(rs.getString("password"));
            }
        }catch(Exception e){
            System.out.println("Operacion no finalizada: " + e.getMessage());
        }finally{
            conn.closeConnection();
        }
        return empleado;
    }
    
}
