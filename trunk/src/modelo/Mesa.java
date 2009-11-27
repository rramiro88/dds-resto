package modelo;

import controlador.MesaView;

public class Mesa {
	private int nroMesa;
	private Mozo mozo;
	private Comanda comandaActual;
	private boolean habilitada;
	private boolean asignada;
	private boolean ocupada;
	private static int ultimaMesa = 0;
	
	
//	Constructor de instancia Mesa
//	-------------------------------------------------------------	
	public Mesa(boolean habilitada){
		this.nroMesa = ++ultimaMesa;
		this.habilitada = habilitada;
		this.asignada = false;
		this.ocupada = false;
	}

//	Metodo get que devuelve un MesaView para pasar a la vista
//	-------------------------------------------------------------	
	public MesaView getMesaView(){
		MesaView mv = new MesaView(nroMesa, habilitada, asignada, ocupada);
		return mv;
	}

	
//	Metodos sets y gets para los atributos de la clase Mesa
//	-------------------------------------------------------------	
	public boolean isAsignada() {
		return asignada;
	}
	public void setAsignada(boolean asignada) {
		this.asignada = asignada;
	}

	public boolean isHabilitada() {
		return habilitada;
	}
	public void setHabilitada(boolean hab) {
		this.habilitada = hab;
	}

	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada() {
		this.ocupada = true;
	}
	
	public Mozo getMozo(){
		return mozo;
	}
	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}
	
	public int getNroMesa(){
		return nroMesa;
	}
	
	public Comanda getComanda(){
		return comandaActual;
	}

	public float getTotal(){
		float total = comandaActual.getTotal();
		return total;
	}
	

//	Metodos que operan con la mesa
//	-------------------------------------------------------------	
	public Comanda abrirMesa(){
		comandaActual = new Comanda(mozo);
		ocupada = true;
		return comandaActual;
	}
	
	public void cerrarMesa(){
		ocupada = false;
		comandaActual = null;
	}

	public void agregarItemComanda(int cant, ItemDeCarta itemCarta){
		comandaActual.agregarItemComanda(cant, itemCarta);
	}
	
	
}

