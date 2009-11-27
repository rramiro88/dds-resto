package controlador;

import modelo.Producto;

public class IngredienteView {
	private float cantidad;
	private Producto producto;
 
	public IngredienteView (Producto product, float cant){
		this.producto = product;
		this.cantidad = cant;
	}

	public float getCantidad() {
		return cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

}
