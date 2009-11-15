package controlador;

import java.util.Vector;

public class MozoView {
	private String nombre;
	private int id;
	private int comision;
	private float liquidacion;
	private boolean habilitado;
	static final String[] encabezados = {"ID", "Nombre", "Comision", "Habilitado"};
	
	public MozoView (int id, String nombre, int comision, boolean habilitado){
		super();
		this.id = id;
		this.nombre = nombre;	
		this.comision = comision;
		this.habilitado = habilitado;
	}
	
	public Vector toVector(){
		Vector v = new Vector();
		v.add(id);
		v.add(nombre);
		v.add(comision);
		v.add(habilitado);
		return v;
	}
	
	static public Vector getEncabezados() {
		Vector v = new Vector();
		for (int i=0; i<encabezados.length; i++){
			v.add(encabezados[i]);
		}
		return v;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getId(){
		return id;
	}
	
	public int getComision() {
		return comision;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
	
	/*	public float getLiquidacion()
	{
		return liquidacion;
	}
*/
}