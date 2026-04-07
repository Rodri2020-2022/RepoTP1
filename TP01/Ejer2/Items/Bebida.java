package Ejer2.Items;

import Ejer2.Pedido;

public class Bebida extends ItemMenu{
    public Bebida(String descripcion, float precio) {
        super(descripcion, precio);
    }

    @Override
    public void agregarAPedido(Pedido pedido) {
        pedido.agregarBebida(this);
    }
}
