
public class Mesa {
	private int nroMesa;
	private Mozo mozo;
	private Comanda comandaActual;
	private boolean ocupada = false;
	private boolean habilitada = false;
	private static int ultimaMesa = 0;
	
	
	public Mesa()
	{
		super();
		this.nroMesa = ++ultimaMesa;
	}
	
	public int getNroMesa()
	{
		return nroMesa;
	}
	
	public Mozo getMozo()
	{
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

}
