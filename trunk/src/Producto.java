import java.util.Vector;


public class Producto {
	private String nombre;
	private float cantidad;
	private int puntoped;
	private int puntoreab;
	private Proveedor proveedor;
	//private boolean isDisponible;
	
	public Producto (String name, int canti, int puntop, int puntor, Proveedor prov){
		this.nombre = name;
		this.cantidad = canti;
		this.puntoped = puntop;
		this.puntoreab = puntor;
		this.proveedor = prov;
		//this.isDisponible = true;
	}
	
	public Vector toVector()
	{
		Vector v = new Vector();
		v.add(nombre);
		v.add(cantidad);
		v.add(puntoped);
		v.add(puntoreab);
		v.add(proveedor.getRazonsocial());
		return v;
	}

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
	}

	public int getPuntoped() {
		return puntoped;
	}
	public void setPuntoped(int puntoped) {
		this.puntoped = puntoped;
	}

	public int getPuntoreab() {
		return puntoreab;
	}
	public void setPuntoreab(int puntoreab) {
		this.puntoreab = puntoreab;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	/*public boolean isDisponible() {
		return isDisponible;
	}
	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}
	
	public boolean esReducible(int cantidadTotal){
		if (this.cantidad - cantidadTotal>=0){
			return true;
		}
		return false;
	}

	public void reducirCantidad(float cantidadTotal){
		this.setCantidad(this.cantidad - cantidadTotal);
	}
*/	
}