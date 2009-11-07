import java.util.Vector;


public class Proveedor {
	private String cuit;
	private String domicilio;
	private String razonsocial;

	public Proveedor (String razonsocial, String domicilio, String cuit){
		this.razonsocial = razonsocial;
		this.domicilio = domicilio;
		this.cuit = cuit;
	}
	
	public Vector toVector()
	{
		Vector v = new Vector();
		v.add(razonsocial);
		return v;
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
