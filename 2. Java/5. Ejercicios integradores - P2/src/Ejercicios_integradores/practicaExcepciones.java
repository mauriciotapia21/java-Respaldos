package Ejercicios_integradores;

public class practicaExcepciones
{
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        int resultado = 0;

        try
        {
            resultado = b/a;
        } catch (ArithmeticException exception)
        {
            System.out.println("¡Se ha producido un error!");
        }
        finally {
            {
                System.out.println("¡programa finalizado!");
            }

            //se procede a realizar el segundo try catch de forma que se pueda mandar un mensaje donde no se pueda dividir por cero
            try
            {
                resultado = b/a;
            }catch (ArithmeticException exception)
            {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }finally {
                System.out.println("¡Programa Finalizado!");

            }
        }
    }
}
