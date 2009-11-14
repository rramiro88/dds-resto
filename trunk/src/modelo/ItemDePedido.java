package modelo;

public class ItemDePedido {
    private Producto producto;
	private float cantidad;
	
//	Constructor de instancia ItemDePedido
//	-------------------------------------------------------------	
	public ItemDePedido (Producto producto, float cantidadPedir){
		this.producto = producto;
	/*	La cantidad a pedir sera la que se asigno en la creacion
		del Producto. Se pasa como parametro al crear el item de pedido.
		La forma de asignar cantidades puede modificarse en el futuro.	*/
		this.cantidad = cantidadPedir;
	//	this.cantidad = producto.getPuntoreab();
	}

//	Metodos sets y gets para los atributos de la clase ItemDePedido
//	-------------------------------------------------------------	
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}