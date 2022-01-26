package ropa;
import Model.prenda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Model.GuardaRopa;

public class Main
{
    public static void main(String[] args)
    {
        //--------------Forma en que yo lo Estructure-----------
       GuardaRopa guardaRopa = new GuardaRopa();
        System.out.println("-----------------playeras registradas----------\n");
        System.out.println("Marca:       Modelo:");
        prenda p1 = new prenda("1- polo    ","polo Ralph Lauren hombre");
        prenda p2 = new prenda("2- polo    ","AE camisa de pique slim fit");

        List<prenda> prendaList = new ArrayList<>();

        prendaList.add(p1);
        prendaList.add(p2);

        for (prenda Ropa : prendaList) {
            System.out.println(Ropa.getMarca() + Ropa.getModelo());
        }

        Integer iIdentificador = guardaRopa.guardarPrendas(prendaList);
        System.out.println("\n------------identificador y ropa------------");
        System.out.printf("\nSu identificador es: %04d\n", iIdentificador);
        guardaRopa.mostrarPrendas();

        List<prenda> revision1 = guardaRopa.devolverPrendas(iIdentificador);
        guardaRopa.mostrarPrendas();
    }
}
