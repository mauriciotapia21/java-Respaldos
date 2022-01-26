package Ejercicio2;
public class Nave {
    private int posicionX;
    private int posicionY;
    private int puntuacion;

    public Nave(int posicionX, int posicionY, int puntuacion) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.puntuacion = puntuacion;
    }

    public Nave(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}