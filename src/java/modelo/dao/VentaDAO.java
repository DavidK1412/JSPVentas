
package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.dto.VentaDTO;
import utils.Connector;

public class VentaDAO {
    private static Connector conn = Connector.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;
    
    public String GenerarSerie(){
        String numSerie = "";
        String SQL = "SELECT max(NumeroSerie) FROM venta";
        try {
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                numSerie = rs.getString(1);
            }
        } catch (Exception err) {
            System.out.println("Operacion no finalizada: " + err.getMessage());
        }
        return numSerie;
    }
    
    public String IDVentas(){
        String idventas = "";
        String SQL = "SELECT max(UUID) FROM venta";
        try {
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                idventas = rs.getString(1);
            }
        } catch (Exception err) {
            System.out.println("Operacion no finalizada: " + err.getMessage());
        }
        return idventas;
    }
    
    public boolean create(VentaDTO obj) {
        String SQL = "INSERT INTO venta(Cliente, Empleado, NumeroSerie, Fecha, Total, Estado) VALUES(?,?,?,?,?,?)";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setString(1, obj.getIDCliente());
            ps.setString(2, obj.getIDEmpleado());
            ps.setString(3, obj.getNumSerie());
            ps.setDate(4, (Date) obj.getFecha());
            ps.setDouble(5, obj.getMonto());
            ps.setInt(6, obj.getEstado());
            ps.executeUpdate();
            return true;
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
            return false;
        }finally{
            conn.closeConnection();
        }
    }
    
    public boolean guardarDetalleVentas(VentaDTO obj) {
        String SQL = "INSERT INTO detalleventa(Venta, Producto, Cantidad, Precio) VALUES(?,?,?,?)";
        try{
            conn = Connector.getInstance();
            ps = conn.getConn().prepareStatement(SQL);
            ps.setInt(1, obj.getID());
            ps.setInt(2, obj.getIDProducto());
            ps.setInt(3, obj.getCantidad());
            ps.setDouble(4, obj.getPrecioProducto());
            ps.executeUpdate();
            return true;
        }catch(Exception err){
            System.out.println("Operacion no finalizada: " + err.getMessage());
            return false;
        }finally{
            conn.closeConnection();
        }
    }
}
