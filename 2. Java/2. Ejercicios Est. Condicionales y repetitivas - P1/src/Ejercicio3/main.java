package Ejercicio3;
import java.util.Scanner;

public class main
{
    public static void main (String[]arg)
    {
        Scanner teclado = new Scanner(System.in);
        int servicio1 = 1500;
        int servicio2 = 2200;

        int i;

        for (i = 1; i <= 7; i++)
        {
            System.out.println("cliente " + i + ", ¿cual es el servicio que contrataras?: ");
            int servicio = teclado.nextInt();

            switch (servicio)
            {
                case 1:
                    System.out.println("el total a pagar del servicio 1 es de: " + servicio1);
                break;
                case 2:
                    System.out.println("el total a pagar del servicio 2 sera de: " + servicio2);
                    break;
                default:
                    System.out.println("Opcion erronea");

            }
        }
    }
}
