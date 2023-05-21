package modelo.dto;

public class VentaDTO {
    private int ID;
    private int item;
    private String IDCliente;
    private String UUIDEmpleado;
    private int IDProducto;
    private String numSerie;
    private String nombreProducto;
    private String Fecha; //Recordar cambiar a dato de tipo Date o Calendar
    private double precioProducto;
    private int cantidad;
    private double subtotal;
    private double monto;
    private int estado;

    public VentaDTO() {
    }

    public VentaDTO(int ID, int item, String IDCliente, String UUIDEmpleado, int IDProducto, String numSerie, String nombreProducto, String Fecha, double precioProducto, int cantidad, double subtotal, double monto, int estado) {
        this.ID = ID;
        this.item = item;
        this.IDCliente = IDCliente;
        this.UUIDEmpleado = UUIDEmpleado;
        this.IDProducto = IDProducto;
        this.numSerie = numSerie;
        this.nombreProducto = nombreProducto;
        this.Fecha = Fecha;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monto = monto;
        this.estado = estado;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(String IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getUUIDEmpleado() {
        return UUIDEmpleado;
    }

    public void setUUIDEmpleado(String UUIDEmpleado) {
        this.UUIDEmpleado = UUIDEmpleado;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
}
