import java.util.Vector;


public class ProductoView {
	private String nombre;
	private float cantidad;
	private float puntoped;
	private float puntoreab;
	private Proveedor proveedor;
	static final String[] encabezados = {"Nombre", "Cantidad", "PuntoDePedido", "PuntoDeReabastecimiento", "Proveedor"};
	
	public ProductoView (String name, float canti, float puntop, float puntor, Proveedor prov){
		this.nombre = name;
		this.cantidad = canti;
		this.puntoped = puntop;
		this.puntoreab = puntor;
		this.proveedor = prov;
//		this.isDisponible = true;
	}
	
	static public Vector getEncabezados() {
		Vector v = new Vector();
		for (int i=0; i<encabezados.length; i++){
			v.add(encabezados[i]);
		}
		return v;
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