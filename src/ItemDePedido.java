public class ItemDePedido {
	private float cantidad;
    private Producto producto;
	
	public ItemDePedido (float cantidad, Producto producto){
		this.cantidad = cantidad;
		this.producto = producto;
	}

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
