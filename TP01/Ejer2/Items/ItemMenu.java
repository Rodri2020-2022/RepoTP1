package Ejer2.Items;

import Ejer2.Pedido;

public abstract class ItemMenu {
    private float precio;
    private String descripcion;

    public ItemMenu(String descripcion, float precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public abstract void agregarAPedido(Pedido pedido);
    public float getPrecio() {
        return precio;
    }
}
