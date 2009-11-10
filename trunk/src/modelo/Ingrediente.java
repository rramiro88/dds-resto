package modelo;



public class Ingrediente {
	private float cantidad;
	private Producto producto;
	//private boolean isFabricable;

//	Constructor de instancia ingrediente 
	public Ingrediente (Producto product, float cant){
		this.producto = product;
		this.cantidad = cant;
		//this.isFabricable = true;
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

	/*public boolean isFabricable() {
		return isFabricable;
	}
	public void setFabricable(boolean isFabricable) {
		this.isFabricable = isFabricable;
	}*/
	
//	Metodos con productos - Preparar plato o bebida
//	-------------------------------------------------------------	

	//	Revisa que la cantidad total de producto alcance para preparar
	//	el total de items de carta requeridos
	public boolean esSuficiente(float cantidadTotal){
		if (producto.getCantidad()>=cantidadTotal)
			return true;
		return false;
	}

	//	Ordena preparar el total de items de carta requeridos
	public void usar(float cantidadTotal){
		this.producto.setCantidad(producto.getCantidad()-cantidadTotal);
	}

}