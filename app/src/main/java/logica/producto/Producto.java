package logica.producto;

public class Producto {
    private String descripcion, nombre, ubicImg;
    private int cantidad, precio;
    private boolean precioVisible;

    public Producto(int disponibilidad) {
        this.cantidad= disponibilidad;
    }

    public Producto(String descripcion, String nombre, boolean precioVisible,int precio, int cantidad) {
        this.descripcion = descripcion;
        this.precio= precio;
        this.cantidad=cantidad;
        this.nombre= nombre;
        this.precioVisible=precioVisible;
    }

    public Producto() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponibilidad() {
        return cantidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.cantidad = disponibilidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPrecioVisible() {
        return precioVisible;
    }

    public void setPrecioVisible(boolean precioVisible) {
        this.precioVisible = precioVisible;
    }

    public String getUbicImg() {
        return ubicImg;
    }

    public void setUbicImg(String ubicImg) {
        this.ubicImg = ubicImg;
    }
}
