package Ejer2;

import Ejer2.Items.Bebida;
import Ejer2.Items.ItemMenu;
import Ejer2.Items.Plato;
import Ejer2.Tarjeta.TarjetaCredito;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int nroPedido;
    private String nombreTitular;
    private List<Bebida> bebidas;
    private List<Plato> platos;

    private float precioTotalBebidas;
    private float precioTotalPlatos;
    private float precioTotal;

    private boolean pagado;

    public Pedido(String nombreTitular, ItemMenu... items) {
        this.nroPedido = (int) (Math.random() * 100);
        this.nombreTitular = nombreTitular;
        this.bebidas = new ArrayList<>();
        this.platos = new ArrayList<>();

        List.of(items).forEach(item -> item.agregarAPedido(this));
        calcularPrecioTotal();
    }

    private void calcularPrecioTotal(){
        this.precioTotal = precioTotalBebidas + precioTotalPlatos;
    }

    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
        this.precioTotalBebidas += bebida.getPrecio();
    }
    public void agregarPlato(Plato plato) {
        platos.add(plato);
        this.precioTotalPlatos += plato.getPrecio();
    }

    public void recibirPago(TarjetaCredito tarjeta, Propina propina){
        System.out.println("Pago: " + precioTotal);

        float pagoConDescuento = tarjeta.aplicarDescuento(precioTotalBebidas, precioTotalPlatos);
        System.out.println("Pago aplicado el descuento: " + pagoConDescuento + " [-" + (precioTotal-pagoConDescuento) + "]");

        float pagoSumadoPropina = aplicarPropina(propina, pagoConDescuento);
        System.out.println("Pago aplicada la propina: " + pagoSumadoPropina + " [+" + (pagoSumadoPropina-pagoConDescuento) + "]");

        tarjeta.pagar(pagoSumadoPropina);
        pagado = true;
    }

    private static float aplicarPropina(Propina propina, float pagoConDescuento) {
        return pagoConDescuento + (pagoConDescuento * propina.getMontoElegido());
    }

}
