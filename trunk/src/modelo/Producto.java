package modelo;

import controlador.ProductoView;

public class Producto {
	private String nombre;
	private float cantidad;
	private float puntoped;
	private float puntoreab;
	private Proveedor proveedor;
	private boolean estaBajoPuntoPedido;


//	Constructor de instancia Producto
//	-------------------------------------------------------------		
	public Producto (String name, float canti, float puntop, float puntor, Proveedor prov){
		this.nombre = name;
		this.cantidad = canti;		//	cantidad existente del producto
		this.puntoped = puntop;		//	cuando el stock es igual o menor a esta cantidad ordenar comprar
		this.puntoreab = puntor;	//	cantidad a pedir cuando se alcanza o supera el punto de pedido
		this.proveedor = prov;
		//	estaBajoPunto de pedido depende de que producto 
		//	sea menor o igual a bajo punto de pedido (o no).
		if(canti <= puntop){
			this.estaBajoPuntoPedido = true;
		}else{
			this.estaBajoPuntoPedido = false;
		}
			
	}

	public ProductoView getProductoView(){
		ProductoView pv = new ProductoView(nombre, cantidad, puntoped, puntoreab, proveedor);
		return pv;
	}

//	Metodos sets y Gets para los atributos de Producto	
//	-------------------------------------------------------------	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
		if (this.getCantidad() <= this.getPuntoped())
			this.setEstaBajoPuntoPedido(true);
	}

	public float getPuntoped() {
		return puntoped;
	}
	public void setPuntoped(float puntoped) {
		this.puntoped = puntoped;
	}

	public float getPuntoreab() {
		return puntoreab;
	}
	public void setPuntoreab(float puntoreab) {
		this.puntoreab = puntoreab;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public boolean estaBajoPuntoPedido() {
		return estaBajoPuntoPedido;
	}
	private void setEstaBajoPuntoPedido(boolean estaBajoPuntoPedido) {
		this.estaBajoPuntoPedido = estaBajoPuntoPedido;
	}

	
}
