
public class MesaView {
	private int nroMesa;
	private Mozo mozo;
	private Comanda comandaActual;	
	
	public MesaView(int nro)
	{
		super();
		this.nroMesa = nro;
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
