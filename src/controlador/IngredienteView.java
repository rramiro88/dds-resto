package controlador;

import java.util.Vector;

import modelo.Producto;

public class IngredienteView {
	private float cantidad;
	private Producto producto;
	static final String[] encabezados = {"Producto", "Cantidad"};
 
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
	
	public Vector toVector()
	{
		Vector v = new Vector();
		v.add(producto);
		v.add(cantidad);
		return v;
	}
	
	static public Vector getEncabezados() {
		Vector v = new Vector();
		for (int i=0; i<encabezados.length; i++){
			v.add(encabezados[i]);
		}
		return v;
	}
	
	

}
