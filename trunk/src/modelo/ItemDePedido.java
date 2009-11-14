/**	
  * La cantidad a pedir se asigno previamente al crear el producto.
  *	La misma se lee desde producto.getPuntoreab() y se pasa como parametro al 
  *	crear el item de pedido. 
  * La forma de asignar cantidades podria modificarse en el futuro.
  *
  **/

package modelo;

public class ItemDePedido {
    private Producto producto;
	private float cantidad;
	
//	Constructor de instancia ItemDePedido
//	-------------------------------------------------------------	
	public ItemDePedido (Producto producto, float cantidadPedir){
		this.producto = producto;
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
