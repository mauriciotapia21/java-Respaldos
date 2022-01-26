package Model;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GuardaRopa
{
    private Integer cont;
    private Map<Integer, List<prenda>> diccionario;

    public GuardaRopa()
    {
        this.cont = 0;
        this.diccionario = new HashMap<>();

    }
    public Integer guardarPrendas(List<prenda> listaDePrenda)
    {
        this.diccionario.put(this.cont, listaDePrenda);
        return this.cont++;

    }

        public void mostrarPrendas()
        {
            System.out.println("Prendas actualmente en el guardarropa: " + cont++);
            for (Map.Entry<Integer, List<prenda>> entrada :
                    this.diccionario.entrySet()) {
                System.out.printf("Identificador %04d: \n", entrada.getKey());
                for (prenda prenda :
                        entrada.getValue()) {
                    System.out.format("%1$5s %2$s\n", "", prenda);
                }
            }
        }
        public List<prenda> devolverPrendas(Integer numero)
        {
            return this.diccionario.remove(numero);
        }

}
