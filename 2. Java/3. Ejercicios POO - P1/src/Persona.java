import java.lang.Math;
public class Persona

{
    private String nombre;
    private int edad;
    private String DNI;
    private double peso;
    private double altura;

    public Persona()
    {

    }
    public Persona(String Nombre, int edad, String dni)
    {
        nombre = Nombre;
        this.edad = edad;
        DNI = dni;
    }

    public Persona(String Nombre, int edad, String dni, double Peso, double Altura)
    {
        nombre = Nombre;
        this.edad = edad;
        DNI = dni;
        peso = Peso;
        altura = Altura;
    }

    public int calcularIMC()
    {
        double IMC = 0, IMC1;
        IMC1 = Math.pow(altura, 2);
        IMC = this.peso / IMC1;
        System.out.println("--------------DATOS PERSONA-------------------\n\n");
        System.out.println("tu indice de masa corporal es de: " + IMC);
        if (IMC < 20 )
        {
            return -1;
        }
       if (IMC >= 20 && IMC <= 25)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
    public boolean calculaMayoriaEdad()
    {
        boolean mayor = false;
        System.out.println("tu edad es: " + edad);
        if (edad >= 18)
        {
            mayor = true;
        }
        if (edad <= 17)
        {
            mayor = false;
        }
        return mayor;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + DNI + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ' ';
    }
}
