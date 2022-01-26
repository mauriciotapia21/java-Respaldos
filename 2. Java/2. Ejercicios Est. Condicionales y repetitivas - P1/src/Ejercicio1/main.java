package Ejercicio1;
import java.util.Scanner;
public class main {
    public static void main (String[]arg)
    {
        Scanner teclado = new Scanner(System.in);
        int fabrica;
        int precio;

        System.out.print("Ingresa el numero de tienda: ");
        fabrica = teclado.nextInt();

        System.out.print("ingresa el precio de producto que se vendera:");
        precio = teclado.nextInt();

        switch(fabrica)
        {
            case 1:
                double envio = (0.07 * precio);
                double suma1 = (precio + envio);
                double ganancia = (0.25 * suma1);
                double total =  (precio + envio + ganancia);
                System.out.println("el costo del envio es de: " + envio);
                System.out.println("la ganancia obtenida es de: " + ganancia);
                System.out.println("El total de la venta es de: " + total);
                break;
            case 2:
                double envio2 = (0.15 * precio);
                double suma2 = (precio + envio2);
                double ganacia2 = (0.25 * suma2);
                double total2 = (envio2 + ganacia2 + precio);
                System.out.println("El costo del envio es de:" + envio2);
                System.out.println("la ganancia obtenida es de: " + ganacia2);
                System.out.println("El de total de la venta es de: " + total2);
                break;
            case 3:
                double envio3 = (0.22 * precio);
                double suma3 = (precio + envio3);
                double ganancia3 = (0.25 * suma3);
                double total3 = (envio3 + ganancia3 + precio);
                System.out.println("El costo del envio es de: " + envio3);
                System.out.println("la ganancia obtenida es de: " + ganancia3);
                System.out.println("El total de la venta es de: " + total3);
                break;

        }

    }
}
