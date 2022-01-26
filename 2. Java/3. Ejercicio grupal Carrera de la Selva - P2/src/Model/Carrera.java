package Model;
import Main.main;

public class Carrera
{
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int número_de_emergencia;
    private String grupo_sanguíneo;
    private int tipo_Circuito;

    public Carrera(int dni, String nombre, String apellido, int edad, int celular, int número_de_emergencia, String grupo_sanguíneo, int tipo_Circuito) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.número_de_emergencia = número_de_emergencia;
        this.grupo_sanguíneo = grupo_sanguíneo;
        this.tipo_Circuito = tipo_Circuito;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNúmero_de_emergencia() {
        return número_de_emergencia;
    }

    public void setNúmero_de_emergencia(int número_de_emergencia) {
        this.número_de_emergencia = número_de_emergencia;
    }

    public String getGrupo_sanguíneo() {
        return grupo_sanguíneo;
    }

    public void setGrupo_sanguíneo(String grupo_sanguíneo) {
        this.grupo_sanguíneo = grupo_sanguíneo;
    }

    public int getTipo_Circuito() {
        return tipo_Circuito;
    }

    public void setTipo_Circuito(int tipo_Circuito) {
        this.tipo_Circuito = tipo_Circuito;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", número_de_emergencia=" + número_de_emergencia +
                ", grupo_sanguíneo='" + grupo_sanguíneo + '\'' +
                ", tipo_Circuito=" + tipo_Circuito +
                '}';
    }
}
