
/**
 * Esta clase hay que borrarla. La orden de compra guardar· directamente
 * el producto a comprar. Para saber la cantidad a pedir se consulta
 * el atributo punto de pedido dentro el objeto PRODUCTO.
 * 
 * **/

public class ItemDePedido {
    private Producto producto;
	private float cantidad;
	
//	Constructor de instancia ItemDePedido
//	-------------------------------------------------------------	
	public ItemDePedido (Producto producto){
		this.producto = producto;
		//	la cantidad a pedir previamente asignada en la creaci√≥n del Producto
		this.cantidad = producto.getPuntoreab();	
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