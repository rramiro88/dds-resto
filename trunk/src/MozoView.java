import java.util.Vector;

public class MozoView {
	private String nombre;
	private int idMozo;
	private int comision;
	private float liquidacion;
	static final String[] encabezados = {"ID", "Nombre", "Comision"};
	//private boolean habilitado = false;
	
	public MozoView (int idMozo, String nombre, int comision)
	{
		super();
		this.idMozo = idMozo;
		this.nombre = nombre;	
		this.comision = comision;
	}
	
	public Vector toVector()
	{
		Vector v = new Vector();
		v.add(idMozo);
		v.add(nombre);
		v.add(comision);
		return v;
	}
	
	static public Vector getEncabezados() {
		Vector v = new Vector();
		for (int i=0; i<encabezados.length; i++){
			v.add(encabezados[i]);
		}
		return v;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getIdMozo()
	{
		return idMozo;
	}
	
/*	public float getLiquidacion()
	{
		return liquidacion;
	}
*/
	public float getComision() {
		return comision;
	}

/*	public boolean getHabilitado (){
		return habilitado;
	}
*/
}
