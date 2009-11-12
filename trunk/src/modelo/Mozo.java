package modelo;

//import java.util.Vector;

import controlador.MozoView;

public class Mozo {
	private String nombre;
	private int id;
	private int comision; //o la guardamos como entero
	private float liquidacion;	//ultima liquidacion de esta mozo (lo que hay que pagarle)
	private boolean habilitado = false;
	private static int ultimoMozo = 100;
	
	public Mozo (String nombre, int comision)
	{
		super();
		this.nombre = nombre;
		this.id = ++ultimoMozo;
		this.comision = comision;
		this.liquidacion = 0;
		this.habilitado = true;
	}
	
	public MozoView getMozoView(){
		MozoView mv = new MozoView(id, nombre, comision);
		return mv;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getId()
	{
		return id;
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
