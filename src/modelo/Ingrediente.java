package modelo;

import controlador.IngredienteView;

public class Ingrediente {
	private float cantidad;
	private Producto producto;

	
//	Constructor de instancia ingrediente 
//	-------------------------------------------------------------	
	public Ingrediente (Producto product, float cant){
		this.producto = product;
		this.cantidad = cant;
	}
	
//	Metodo get que devuelve un IngredienteView para pasar a la vista
//	-------------------------------------------------------------	
	public IngredienteView getIngredienteView(){
		IngredienteView iv = new IngredienteView(producto, cantidad);
		return iv;
	}

	
//	Metodos sets y Gets para los atributos de Ingrediente	
//	-------------------------------------------------------------	
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cuantiti) {
		this.cantidad = cuantiti;
	}

	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto product) {
		this.producto = product;
	}	
	
//	Metodos que operan con productos
//	-------------------------------------------------------------	
	//	Revisa que la cantidad total de producto alcance para
	//	preparar el total de platos o bebidas requeridos.
	public boolean esSuficiente(float cantidadTotal){
		if (producto.getCantidad()>=cantidadTotal)
			return true;
		return false;
	}

	//	Ordena al producto restarse la cantidad requerida para el plato-bebida
	public void usar(float cantidadTotal){
		this.producto.setCantidad(producto.getCantidad()-cantidadTotal);
	}

}