package Ejercicio4;
import java.util.Scanner;

public class main
{
    public static void main (String[]arg)
    {
        Scanner teclado = new Scanner(System.in);
        int SUSCR;
        int  i;
        int letraA = 0, LetraB = 0, LetraC = 0, LetraD = 0, LetraE = 0;
        for (i = 1; i <= 50; i++)
        {
            System.out.println("Encuesta.");
            System.out.println("Cual es el diario en el que te suscribiste: ");
            System.out.println("1. Diario A: ");
            System.out.println("2. Diario A y B: ");
            System.out.println("3. Diario A y C");
            System.out.println("4. Diario B y C");
            System.out.println("5. Diario A, B y C");
            System.out.println("INGRESE EL DIARIO QUE USTED SE SUSCRIBE: ");
            SUSCR = teclado.nextInt();

            switch (SUSCR)
            {
                case 1:
                    letraA++;
                    break;
                case 2:
                     LetraB++;
                     break;
                case 3:
                    LetraC++;
                case 4:
                    LetraD++;
                case 5:
                    LetraE++;
            }

        }
        System.out.println("¿Cuántos están suscriptos a los 3 diarios?: " + LetraE);
        System.out.println("¿Cuántos están suscriptos al Diario A y al Diario C?: " + LetraC);
        System.out.println("¿Cuántos están suscriptos al Diario A y al Diario B?: " + LetraB);
        System.out.println("¿Cuántos están suscriptos al Diario B y al Diario C?: " + LetraD);
        System.out.println("¿Cuántos están suscriptos sólo al Diario A?: " + letraA);

    }
}
