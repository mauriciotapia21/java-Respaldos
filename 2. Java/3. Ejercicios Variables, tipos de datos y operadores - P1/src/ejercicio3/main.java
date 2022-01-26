package ejercicio3;
import java.util.Scanner;
public class main
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int dolares = 2;
        int campaña;
        int Resultado;

        System.out.print("ingresa los dias de camapaña trabajados: ");
        campaña = teclado.nextInt();

        Resultado = dolares * campaña;

        System.out.println("tu monto total es de: " + Resultado);

    }
}
