package controlador;

public class ProveedorView {
	private String cuit;
	private String razonsocial;
	private String domicilio;

	public ProveedorView (String cuit, String razonsocial, String domicilio){
		this.cuit = cuit;
		this.razonsocial = razonsocial;
		this.domicilio = domicilio;
	}
	
	public String getRazonsocial() {
		return razonsocial;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public String getCuit() {
		return cuit;
	}
	
}
