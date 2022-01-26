package Ejercicio1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int temperaturas[][] = new int [2][10];
        int temperaturaAlta = temperaturas[0][0];
        int temperaturaBaja = temperaturas[0][0];
        String ciudades[] = new String[10];
        String ciudadMayor = null;
        String ciudadMenor = null;

        System.out.println("\n------------CIUDADES----------\n");
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "San paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";
        for (int k=0; k<ciudades.length; k++){
            System.out.println("ciudad: " + ciudades[k]);
        }

        System.out.println("\n------------TEMPERATURAS----------\n");
        temperaturas[0][0] = -2;
        temperaturas[0][1] = -3;
        temperaturas[0][2] = -8;
        temperaturas[0][3] = 4;
        temperaturas[0][4] = 6;
        temperaturas[0][5] = 5;
        temperaturas[0][6] = 0;
        temperaturas[0][7] = -7;
        temperaturas[0][8] = -1;
        temperaturas[0][9] = -10;

        temperaturas[1][0] = 33;
        temperaturas[1][1] = 32;
        temperaturas[1][2] = 27;
        temperaturas[1][3] = 34;
        temperaturas[1][4] = 42;
        temperaturas[1][5] = 43;
        temperaturas[1][6] = 39;
        temperaturas[1][7] = 26;
        temperaturas[1][8] = 31;
        temperaturas[1][9] = 35;


        for(int i=0; i< temperaturas.length; i++){
            for(int j=0; j< temperaturas[i].length; j++){
                if(temperaturas[i][j] > temperaturaAlta){
                    temperaturaAlta = temperaturas[i][j];
                    ciudadMayor = ciudades[j];
                }
                if(temperaturas[i][j] < temperaturaBaja){
                    temperaturaBaja = temperaturas[i][j];
                    ciudadMenor = ciudades[j];
                }
            }
        }
        for (int r=0; r<2 ;r++){
            for (int m=0; m<10; m++){
                System.out.println("Fila: " +r+ " Columna: "+m+ " = " + temperaturas[r][m]);
            }
        }

        System.out.println("\nLa temperatura mas baja es de: " + temperaturaBaja + " y la ciudad que la posee es " + ciudadMenor);
        System.out.println("La temperatura mas alta es de: " + temperaturaAlta + " y la ciudad que la posee es " + ciudadMayor);

    }
}



