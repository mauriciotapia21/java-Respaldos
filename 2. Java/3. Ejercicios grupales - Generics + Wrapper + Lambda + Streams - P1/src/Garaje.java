import java.util.List;

 public class Garaje {
        private int identificador;
        private List<Vehiculo> listaVehiculos;

        public Garaje(int identificador, List<Vehiculo> listaVehiculos) {
            this.identificador = identificador;
            this.listaVehiculos = listaVehiculos;
        }

        public int getIdentificador() {
            return identificador;
        }

        public void setIdentificador(int identificador) {
            this.identificador = identificador;
        }

        public List<Vehiculo> getListaVehiculos() {
            return listaVehiculos;
        }

        public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
            this.listaVehiculos = listaVehiculos;
        }
}
