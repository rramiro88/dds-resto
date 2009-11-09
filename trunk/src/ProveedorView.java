
import java.util.Vector;

public class ProveedorView {
	private String cuit;
	private String razonsocial;
	private String domicilio;
	static final String[] encabezados = {"CUIT", "Razón Social", "Domicilio"};

	public ProveedorView (String cuit, String razonsocial, String domicilio){
		this.cuit = cuit;
		this.razonsocial = razonsocial;
		this.domicilio = domicilio;
	}
	
	public Vector toVector()
	{
		Vector v = new Vector();
		v.add(cuit);
		v.add(razonsocial);
		v.add(domicilio);
		return v;
	}
	
	static public Vector getEncabezados() {
		Vector v = new Vector();
		for (int i=0; i<encabezados.length; i++){
			v.add(encabezados[i]);
		}
		return v;
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
