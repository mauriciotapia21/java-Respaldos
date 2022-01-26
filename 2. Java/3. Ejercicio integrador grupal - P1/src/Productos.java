public class Productos
{
    //Se crean los atributos
    private String nombre;
    private double precio;

    //Se crea el constructor
    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    //Se crean los getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", precio=" + precio +", ";
    }

    //Se crea el metodo calcular para que sea capaz de
    // multiplicar el precio del producto por la cantidad qu lleva.
    public double calcular(int cantidadDeProductos)
    {
        return precio * cantidadDeProductos;
    }
}
