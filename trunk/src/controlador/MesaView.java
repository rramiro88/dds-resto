package controlador;

import java.util.Vector;

import modelo.Comanda;
import modelo.Mozo;


public class MesaView {
	private int nroMesa;
	private boolean habilitada;
	private boolean asignada;
	private boolean ocupada;
	//private Mozo mozo;
	//private Comanda comandaActual;
	static final String[] encabezados = {"NroMesa", "Mozo", "ComandaActual"};

	
	public MesaView(int nro, boolean habilitada, boolean asignada, boolean ocupada)
	{
		super();
		this.nroMesa = nro;
		this.habilitada = habilitada;
		this.asignada = asignada;
		this.ocupada = ocupada;
	}
	
	public Vector toVector()
	{
		Vector v = new Vector();
		v.add(nroMesa);
		v.add(asignada);
		v.add(ocupada);
		//v.add(comandaActual);
		return v;
	}
	
	static public Vector getEncabezados() {
		Vector v = new Vector();
		for (int i=0; i<encabezados.length; i++){
			v.add(encabezados[i]);
		}
		return v;
	}
	
	public int getNroMesa()
	{
		return nroMesa;
	}
	
	public boolean isHabilitada() {
		return habilitada;
	}

	public boolean isAsignada() {
		return asignada;
	}

	public boolean isOcupada() {
		return ocupada;
	}
	
	
	/*public Mozo getMozo(){
		return mozo;
	}
	
	public Comanda getComanda(){
		return comandaActual;
	}
*/
}
