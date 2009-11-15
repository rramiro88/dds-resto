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
	
	
	public Mesa(boolean habilitada){
		super();
		this.nroMesa = ++ultimaMesa;
		this.habilitada = habilitada;
		this.asignada = false;
		this.ocupada = false;
	}
	
	public boolean isAsignada() {
		return asignada;
	}

	public void setAsignada(boolean asignada) {
		this.asignada = asignada;
	}
	
	public int getNroMesa(){
		return nroMesa;
	}
	
	public Mozo getMozo(){
		return mozo;
	}
	
	public boolean isOcupada() {
		return ocupada;
	}
	
	public void agregarItemComanda(int cant, ItemDeCarta itemCarta){
		comandaActual.agregarItemComanda(cant, itemCarta);
	}

	public void setOcupada() {
		this.ocupada = true;
	}
	
	public void setNoOcupada() {
		this.ocupada = false;
	}
	
	public Comanda getComanda(){
		return comandaActual;
	}
	
	public void setComandaActual(Comanda comandaActual) {
		this.comandaActual = comandaActual;
	}
	
	public Comanda abrirMesa(){
		comandaActual = new Comanda(mozo);
		ocupada = true;
		return comandaActual;
	}
	
	
	public float cerrarMesa(){
		float total = comandaActual.getTotal(); //ver como llamamos el metodo
		ocupada = false;
		comandaActual = null;
		return total;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean hab) {
		this.habilitada = hab;
	}
	
//	Metodo get que devuelve un MesaView para pasar a la vista
	public MesaView getMesaView(){
		MesaView mv = new MesaView(nroMesa);
		return mv;
	}

}