package ejercicio4;
import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        System.out.print("BIENVENIDO, AQUI PODRAS SABER CUANTO SE TE DESCONTARA DE TU PREMIO CON LOS IMPUESTOS APLICADOS");
        Scanner teclado = new Scanner(System.in);
        double monto_total;
        double impuesto1 = 0.0245;
        double impuesto2 = 0.15;
        double impuesto3 = 0.03;

        System.out.print("\n\ningresa el monto total del premio: ");
        monto_total = teclado.nextInt();


        double rebaja1;
        rebaja1 =(monto_total * impuesto1);
        double rebaja2;
        rebaja2= (monto_total * impuesto2);
        double rebaja3;
        rebaja3 = (monto_total * impuesto3);

        double descuento1 = (monto_total - rebaja1);
        double descuento2 = (monto_total - rebaja2);
        double descuento3 = (monto_total - rebaja3);

        System.out.println("tu monto total con el 2.45% de impuesto descontado es de: " + descuento1);
        System.out.println("Tu monto total con el 15% de impuesto descontado  es de: " + descuento2);
        System.out.println("Tu monto total con el 3% de impuesto descontado es de: " + descuento3);



    }
}
