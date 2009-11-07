public class Proveedor {
	private String cuit;
	private String razonsocial;
	private String domicilio;
	

	public Proveedor (String cuit, String razonsocial, String domicilio){
		this.cuit = cuit;
		this.razonsocial = razonsocial;
		this.domicilio = domicilio;
	}
	
	public ProveedorView getProveedorView(){
		ProveedorView pv = new ProveedorView(cuit, razonsocial, domicilio);
		return pv;
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

	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
}
