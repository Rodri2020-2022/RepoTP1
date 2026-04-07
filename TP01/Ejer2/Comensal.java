package Ejer2;

import Ejer2.Tarjeta.TarjetaCredito;

public class Comensal {
    private String nombre, dni;
    private TarjetaCredito tarjeta;

    public Comensal(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarTarjeta(TarjetaCredito tarj){
        this.tarjeta = tarj;
        this.tarjeta.asignarTitular(this);
    }

    public void pagarPedidoYPropina(Pedido pedido, Propina propina){
        pedido.recibirPago(tarjeta, propina);
    }

    public String getNombre() {
        return nombre;
    }
}
