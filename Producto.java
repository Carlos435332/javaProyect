public class Producto {
    private final String nombre;
    private final double precio;
    private final double abono;

    public Producto(String nombre, double precio, double abono) {
        this.nombre = nombre;
        this.precio = precio;
        this.abono = abono;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getAbono() {
        return abono;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio + " (Abono: $" + abono + ")";
    }
}
