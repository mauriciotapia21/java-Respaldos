import jdk.swing.interop.SwingInterOpUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo v2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo v3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo v4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo v5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo v6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo v7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo v8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo v9 = new Vehiculo("Corolla", "Toyota", 1200);
        Vehiculo v10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo v11 = new Vehiculo("Logan", "Renault", 950);

        //Agregamos todos los vehículos a nuestra lista
        List<Vehiculo> listaVehiculos = Stream.of(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11)
                .collect(Collectors.toList());

        //La lista, la pasamos al garaje
        Garaje garaje1 = new Garaje(1, listaVehiculos);
        //listaVehiculos.forEach(System.out::println);

        //Ordenamos la lista por orden de precio
        List<Vehiculo> listaOrdenada = listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());

        //Ordenamos la lista ordenada por precio, ahora por marca
        List<Vehiculo> listaOrdenadaMarca = listaOrdenada.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .collect(Collectors.toList());

        List<Vehiculo> listaMenos1000 = new ArrayList<>();
        List<Vehiculo> listaMayor1000 = new ArrayList<>();

        int total = 0;
        //Condicion para, en base al costo de cada vehiculo, agregarlo a una lista o a otra.
        for (Vehiculo vehiculo : listaOrdenada) {
            if (vehiculo.getCosto() < 1000) {
                listaMenos1000.add(vehiculo);
            } else {
                listaMayor1000.add(vehiculo);
            }
            total += vehiculo.getCosto();
        }
        double promedioCosto = total / 11;
        System.out.println("VEHICULOS CON COSTO MENOR A 1000");
        listaMenos1000.forEach(System.out::println);
        System.out.println("\n");
        System.out.println("VEHICULOS CON COSTO MAYOR A 1000");
        listaMayor1000.forEach(System.out::println);
        System.out.println("\n");
        System.out.printf("El promedio de costo es de :$%.2f", promedioCosto);


    }
}
