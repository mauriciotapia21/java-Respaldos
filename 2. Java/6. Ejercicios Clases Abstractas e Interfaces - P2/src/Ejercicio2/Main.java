package Ejercicio2;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int asteroideX = (int) (Math.random() * (255 - 0));
        int asteroideY = (int) (Math.random() * (255 - 0));

        System.out.println("Coordenada X asteriode: " + asteroideX);
        System.out.println("Coordenada Y asteriode: " + asteroideY);

        //Creamos una nave simple
        Nave nave1 = new Nave(50, 128);
        int posicionXNave = nave1.getPosicionX();
        int posicionYNave = nave1.getPosicionY();

        //Creacion de una flota Random
        List<Nave> flota1 = new LinkedList<>();
        flota1.add(new Nave(100, 255));
        flota1.add(new Nave(200, 200));

        int posicionXTotal = 0;
        int posicionYTotal = 0;
        for (Nave naveFlota : flota1) {
            posicionXTotal += naveFlota.getPosicionX();
            posicionYTotal += naveFlota.getPosicionY();
        }
        int posicionXFlota = posicionXTotal / 2;
        int posicionYFlota = posicionYTotal / 2;
        System.out.println("Posicion X flota: " + posicionXFlota);
        System.out.println("Posicion Y flota: " + posicionYFlota);


        double posicionFlota = Math.sqrt((Math.pow((posicionXFlota - asteroideX), 2)) + (Math.pow((posicionYFlota - asteroideY), 2)));
        double posicionNave = Math.sqrt((Math.pow((posicionXNave - asteroideX), 2)) + (Math.pow((posicionYNave - asteroideY), 2)));


        System.out.println("Distancia flota: " + posicionFlota);
        System.out.println("Distancia de la nave: " + posicionNave);

        if (posicionFlota < posicionNave) {
            System.out.println("La flota es el ganador!!!");
        } else {
            System.out.println("La nave solitaria es la ganadora");
        }

    }
}