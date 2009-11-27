package controlador;

import java.util.Vector;

public class MesaView {
	private int nroMesa;
	private boolean habilitada;
	private boolean asignada;
	private boolean ocupada;
	static final String[] encabezados = {"NroMesa", "Mozo", "ComandaActual"};

	
	public MesaView(int nro, boolean habilitada, boolean asignada, boolean ocupada)
	{
		super();
		this.nroMesa = nro;
		this.habilitada = habilitada;
		this.asignada = asignada;
		this.ocupada = ocupada;
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
