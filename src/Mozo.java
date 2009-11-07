import java.util.Vector;

public class Mozo {
	private String nombre;
	private int idMozo;
	private int comision; //o la guardamos como entero
	private float liquidacion;	//ultima liquidacion de esta mozo (lo que hay que pagarle)
	private boolean habilitado = false;
	private static int ultimoMozo = 0;
	
	/*
	public Mozo (String nombre, int idMozo, float comision)
	{
		super();
		this.nombre = nombre;
		this.idMozo = idMozo;
		this.comision = comision;
	}
	*/
	
	public Mozo (String nombre, int comision)
	{
		super();
		this.nombre = nombre;
		this.idMozo = ++ultimoMozo;
		this.comision = comision;
	}
	
	public MozoView getMozoView(){
		MozoView mv = new MozoView(idMozo, nombre, comision);
		return mv;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getIdMozo()
	{
		return idMozo;
	}
	
	public float getLiquidacion()
	{
		return liquidacion;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}
	
	public void setHabilitado (){
		habilitado = true;
	}
	
	public boolean getHabilitado (){
		return habilitado;
	}
	
	public void setNoHabilitado (){
		habilitado = false;
	}
	
	public void setNombre (String Nombre){
		nombre = Nombre;
	}
	
}
