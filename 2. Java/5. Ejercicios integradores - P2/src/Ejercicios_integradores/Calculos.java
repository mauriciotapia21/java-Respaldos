package Ejercicios_integradores;
import java.util.Scanner;
public class Calculos
{
    //Se utiliza el metodo Math para realizar las siguientes operaciones.
    //Se crea una clase publica estica de tipo entero para de ahi derivar el numero mayor
    public static int numeroMayor()
    {
        //Se declaran 2 variables que guardaran un valor.
        int num1 = 1;
        int num2 = 10;
        //se retorna el numero mayor para mostrarlo cuando se mande a llamar
        return Math.max(num1,num2);
    }
    public static int numeroMenor()
    {
        //Se declaran 2 variables que guardaran un valor.
        int num1 = 5;
        int num2 = 10;
        //se retorna el numero menor para mostrarlo cuando se mande a llamar
        return Math.min(num1,num2);
    }
    public static double potenciaNumero()
    {
        //Se declaran 2 variables que guardaran un valor.
        int num = 5;
        int potencia = 3;
        return Math.pow(num,potencia);
    }
    public static double coseno()
    {
        //Se declaran 1 variable que guardaran un valor.
        double angulo = 3;
        return Math.cos(angulo);
    }
    public static double raizCuadrada()
    {
        //Se declaran 1 variables que guardaran un valor.
        double raiz = 5;
        return Math.sqrt(raiz);
    }
    public static double numeroAleatorio()
    {
        return (int) (Math.random() * 1000);
    }
}
