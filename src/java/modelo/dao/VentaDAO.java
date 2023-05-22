
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
