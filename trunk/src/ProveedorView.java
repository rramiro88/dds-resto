
public class ProveedorView {
	private String razonsocial;
	private String domicilio;
	private int cuit;

	public ProveedorView (String razonsocial, String domicilio, int cuit){
		this.razonsocial = razonsocial;
		this.domicilio = domicilio;
		this.cuit = cuit;
	}

	public String getRazonsocial() {
		return razonsocial;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public int getCuit() {
		return cuit;
	}
	
}
