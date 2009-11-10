package controlador;

import java.util.Vector;

import modelo.Comanda;
import modelo.Mozo;


public class MesaView {
	private int nroMesa;
	private Mozo mozo;
	private Comanda comandaActual;
	static final String[] encabezados = {"NroMesa", "Mozo", "ComandaActual"};

	
	public MesaView(int nro)
	{
		super();
		this.nroMesa = nro;
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
	
	public Mozo getMozo()
	{
		return mozo;
	}
	
	public Comanda getComanda(){
		return comandaActual;
	}

}
