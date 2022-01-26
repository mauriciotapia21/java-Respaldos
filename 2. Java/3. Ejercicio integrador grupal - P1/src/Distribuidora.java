public class Distribuidora
{
    public static void main(String[] args) {


        Productos[] productos = new Productos[5];
        productos[0] = new Productos("Arroz",50.00);
        productos[1] = new Perecederos("Leche", 10, 4);
        productos[2] = new NoPerecedero("Galletas", 10.00, "tipo1");
        productos[3] = new Perecederos("Salmon",10.00,4);
        productos[4] = new Productos("Cereal",10.00);

        System.out.println("\n------------Lista de productos--------------");

        System.out.println("\n\nProducto: " + productos[0].getNombre() + " el precio es: " + productos[0].calcular(1));
        System.out.println("Producto: " + productos[1].getNombre() + " el precio es: " + productos[1].calcular(1));
        System.out.println("Producto: " + productos[2].getNombre() + " el precio es: " + productos[2].calcular(1));
        System.out.println("Producto: " + productos[3].getNombre() + " el precio es: " + productos[3].calcular(1));
        System.out.println("Producto: " + productos[4].getNombre() + " el precio es: " + productos[4].calcular(1));
        double total = 0;
        for (Productos producto: productos) {
            total += producto.calcular(1); //Polimorfismo
        }

        //Muestro el total


        System.out.println("\nel total es "+total);

    }
}
