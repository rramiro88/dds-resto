
public class ProductoView {
	private String nombre;
	private float cantidad;
	private float puntoped;
	private float puntoreab;
	private Proveedor proveedor;
	public ProductoView (String name, float canti, float puntop, float puntor, Proveedor prov){
		this.nombre = name;
		this.cantidad = canti;
		this.puntoped = puntop;
		this.puntoreab = puntor;
		this.proveedor = prov;
//		this.isDisponible = true;
	}

	public String getNombre() {
		return nombre;
	}
	public float getCantidad() {
		return cantidad;
	}
	public float getPuntoped() {
		return puntoped;
	}
	public float getPuntoreab() {
		return puntoreab;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	
}