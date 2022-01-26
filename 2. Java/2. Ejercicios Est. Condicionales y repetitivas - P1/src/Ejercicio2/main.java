package Ejercicio2;
import java.util.Scanner;

public class main
{
    public static void main (String[]arg)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa tu DNI: ");
        int dni = teclado.nextInt();

        System.out.println("Ingresa el monto que ganas: ");
        int monto = teclado.nextInt();

        if (monto <= 20000)
        {
            double aumento = (monto + (monto * .20));
            System.out.println("debido a que ganas menos de $20,000 tu sueldo ahora con el 20% es de: " + aumento);
        }
        if (monto > 20000 && monto <= 45000)
        {
            double aumento2 = (monto + (monto * 0.1));
            System.out.println("debido a que ganas menos de $20,000 tu sueldo ahora con el 10% es de: " + aumento2);
        }
        if (monto > 45000)
        {
            double aumento3 = (monto + (monto * 0.05));
            System.out.println("debido a que ganas menos de $20,000 tu sueldo ahora con el 5% es de: " + aumento3);
        }
    }
}
