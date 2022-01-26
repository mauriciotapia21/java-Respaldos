package Model;
import java.util.HashMap;
import java.util.Map;

public class CircuitoMe
{
    Map<Integer,Carrera> ParticipanteCarrera = new HashMap<>();

    public void inscripcion(Carrera participante){
        int keyValue = ParticipanteCarrera.size() + 1;
        participante.setTipo_Circuito(2000);
        if (participante.getEdad() > 18){
            participante.setTipo_Circuito(2300);
        }
        ParticipanteCarrera.put(keyValue,participante);
    }

    public Map<Integer, Carrera> regresarparticipante(){
        return regresarparticipante();
    }

    public void desinscribir(int key){
        regresarparticipante().remove(key);
    }

    public int monto(){
        int monto = 0;
        for (Map.Entry<Integer, Carrera> participante : ParticipanteCarrera.entrySet()){
            monto = monto + participante.getValue().getTipo_Circuito();
        }
        return monto;
    }
}
