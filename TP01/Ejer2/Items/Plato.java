package Ejer2.Items;

import Ejer2.Pedido;

public class Plato extends ItemMenu {
    private String nombrePlatillo;
    private TIPO tipoPlato;

    public Plato(String nombrePlatillo, String descripcion, float precio, TIPO tipoPlato) {
        super(descripcion, precio);
        this.nombrePlatillo = nombrePlatillo;
        this.tipoPlato = tipoPlato;
    }

    @Override
    public void agregarAPedido(Pedido pedido) {
        pedido.agregarPlato(this);
    }
}
