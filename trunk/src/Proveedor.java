
public class Proveedor {
	private String razonsocial;
	private String domicilio;
	private int cuit;

	public Proveedor (String razonsocial, String domicilio, int cuit){
		this.razonsocial = razonsocial;
		this.domicilio = domicilio;
		this.cuit = cuit;
	}

	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	
}
