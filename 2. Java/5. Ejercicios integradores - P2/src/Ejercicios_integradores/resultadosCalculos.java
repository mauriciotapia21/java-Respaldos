package Ejercicios_integradores;

public class resultadosCalculos
{
    public static void main(String[] args) {
        //Aqui se mandan a llamar las operaciones, funciones que hicimos mediante el metodo Math con un breve mensaje.
        System.out.println("El numero mayor es: "+Calculos.numeroMayor());
        System.out.println("El numero menor es: "+Calculos.numeroMenor());
        System.out.println("La potencia del numero es: "+Calculos.potenciaNumero());
        System.out.println("El coseno del numero es: "+Calculos.coseno());
        System.out.println("La raiz cuadrada del numero es: "+Calculos.raizCuadrada());
        System.out.println("El numero que te toco es: "+Calculos.numeroAleatorio());
    }
}
