package Ejercicios_integradores;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class practicaExcepciones2 {
    public static void main(String[] args) {
        String mensajeFinal = "Este es el ultimo mensaje";

        try {
            int[] numeros = new int[5];
            numeros[5] = 10;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println(mensajeFinal);
        }

    }

    public void leerArchivo(String nombreArchivo) {
        String texto = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivo));

            while ((texto = bufferedReader.readLine()) != null) {
                System.out.println(texto);
            }
            bufferedReader.close();
        }catch (FileNotFoundException ex) {
            System.out.println("No se puede encontrar el archivo especificado");
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo especificado");
        }
    }
}
