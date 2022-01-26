public class Main
{
    public static void main(String[] args)
    {
        Persona persona = new Persona();
        Persona Persona1 = new Persona("Johana Tapia",15,"12345",57.6,1.52);
        Persona persona2 = new Persona("Gabriela Huerta",21,"23432",53.8,1.49);
        Persona persona3 = new Persona("Gustavo rodriguez",22,"GRMZ23456");

        int imc = Persona1.calcularIMC();
        if (imc == -1)
        {
            System.out.println("--usted se encuentra bajo de peso");
        }
        else if(imc == 0)
        {
            System.out.println("--Usted tiene un peso saludable");
        }
        else  if (imc == 1)
        {
            System.out.println("--Usted cuenta con sobrepeso: ");
        }

        boolean esMayor = Persona1.calculaMayoriaEdad();
        if (esMayor == true) {
            System.out.println("--Usted es mayor de edad");
        } else {
            System.out.println("--Usted es menor de edad");
        }

        System.out.println("Los datos de la persona son: " + Persona1.toString());
    }
}
