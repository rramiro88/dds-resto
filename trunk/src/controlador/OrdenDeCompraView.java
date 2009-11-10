package controlador;

import java.util.Vector;

public class OrdenDeCompraView {
	private int numero;
	private Vector <ItemDePedido> itemsDePedido;
	private Proveedor proveedor;

	public OrdenDeCompraView (int numero, Proveedor proveedor){
		this.numero = numero;
		itemsDePedido = new Vector<ItemDePedido>();
		this.proveedor = proveedor;
	}

	public int getNumero() {
		return numero;
	}

	public Vector<ItemDePedido> getItemsDePedido() {
		return itemsDePedido;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	
}