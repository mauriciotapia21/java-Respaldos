package Main;
import Model.Carrera;
import Model.CircuitoC;
import Model.CircuitoA;
import Model.CircuitoMe;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class main
{
    public static void main(String[] args)
    {

        Carrera P1 = new Carrera(1,"juanito","americo",21,812345667,828354657,"O+",1);
        Carrera P2 = new Carrera(2,"miguel","huerta",22,812345667,828354657,"O+",2);
        Carrera P3 = new Carrera(3,"paola","campos",21,812345667,828354657,"O+",3);
        Carrera P4 = new Carrera(4,"noel","lopez",55,812345667,828354657,"O+",2);
        Carrera P5 = new Carrera(5,"ramon","garcia",19,812345667,828354657,"O+",3);

        List<Carrera> CarreraList = new ArrayList<>();

        CarreraList.add(P1);
        CarreraList.add(P2);
        CarreraList.add(P3);
        CarreraList.add(P4);
        CarreraList.add(P5);


        for (Carrera carreras : CarreraList) {

            System.out.println("-------personas registradas--------------");
            System.out.println("DNI: " + carreras.getDni()+ " " + "Nombre: " + carreras.getNombre() +" "+ "Apellidos: " + carreras.getApellido() +" "+
                    " "+"Celular: " + carreras.getCelular()+ " " + "Numero de emergencia: "+carreras.getNúmero_de_emergencia() +" "+ "Edad: " + carreras.getEdad() +" "+ "Tipo de circuito: " + carreras.getTipo_Circuito());

            
            System.out.println("\n\n-------Datos Extra---------");

            CircuitoC circuitoChico = new CircuitoC();
            CircuitoMe circuitoMedio = new CircuitoMe();
            CircuitoA circuitoAvanzado = new CircuitoA();
            Map<Integer, Carrera> participantesedicionpeque = new HashMap<>();
            Map<Integer, Carrera> participanteedicionMedia = new HashMap<>();
            Map<Integer, Carrera> participanteedicionAvanzada = new HashMap<>();

            for (int i = 0; i < 9; i++) {
                if (i < 3){
                    Carrera participante = CarreraList.get(i);
                    circuitoChico.inscripcion(participante);
                    continue;
                }
                if (i > 2 && i < 6){
                    Carrera participante = CarreraList.get(i);
                    circuitoMedio.inscripcion(participante);
                    continue;
                }
                Carrera participante = CarreraList.get(i);
                circuitoAvanzado.inscripcion(participante);
            }

            System.out.println("Los participantes inscritos en el circuito chico son: ");
            participantesedicionpeque = circuitoChico.regresarparticipante();
            for (Map.Entry<Integer, Carrera> participanteChico : participantesedicionpeque.entrySet()){
                System.out.println(participanteChico);
            }

            System.out.println("");

            System.out.println("Los participantes inscritos en el circuito medio son: ");
            participanteedicionMedia = circuitoMedio.regresarparticipante();
            for (Map.Entry<Integer, Carrera> participanteMedio : participanteedicionMedia.entrySet()){
                System.out.println(participanteMedio);
            }

            System.out.println("");

            System.out.println("Los participantes inscritos en el circuito avanzado son: ");
            participanteedicionAvanzada = circuitoAvanzado.regresarparticipante();
            for (Map.Entry<Integer, Carrera> participanteAvanzado : participanteedicionAvanzada.entrySet()){
                System.out.println(participanteAvanzado);
            }

            circuitoAvanzado.desinscribir(1);

            int montoChico = circuitoChico.monto();
            int montoMedio = circuitoMedio.monto();
            int montoAvanzado = circuitoAvanzado.monto();
            int montoTotal = montoChico + montoMedio + montoAvanzado;

            System.out.println("");

            System.out.println("El monto para el circuito chico es: " + montoChico);
            System.out.println("El monto para el circuito medio es: " + montoMedio);
            System.out.println("El monto para el circuito avanzado es: " + montoAvanzado);
            System.out.println("El monto total de toda la carrera es: " + montoTotal);
        }
    }
}
