import java.util.Vector;


public class ProveedorView {
	private String razonsocial;
	private String domicilio;
	private int cuit;
	static final String[] encabezados = {"Razón Social", "Domicilio", "CUIT"};

	public ProveedorView (String razonsocial, String domicilio, int cuit){
		this.razonsocial = razonsocial;
		this.domicilio = domicilio;
		this.cuit = cuit;
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
	public int getCuit() {
		return cuit;
	}
	
}
