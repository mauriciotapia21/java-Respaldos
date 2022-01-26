package Model;

public class prenda
{
    private String marca;
    private String modelo;

    public prenda(String marca, String modelo)
    {
        setMarca(marca);
        setModelo(modelo);
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda [ Marca: " + getMarca() + ", Modelo: " + getModelo() + " ]";
    }
}
