package modelo;

//import java.util.Vector;

import controlador.MozoView;

public class Mozo {
	private String nombre;
	private int id;
	private int comision; //o la guardamos como entero
	private float liquidacion;	//ultima liquidacion de esta mozo (lo que hay que pagarle)
	private boolean habilitado;
	private static int ultimoMozo = 100;
	
//	Constructor de instancia Mozo
//	-------------------------------------------------------------	
	public Mozo (String nombre, int comision, boolean habilitado){
		super();
		this.nombre = nombre;
		this.id = ++ultimoMozo;
		this.comision = comision;
		this.liquidacion = 0;
		this.habilitado = habilitado;
	}
	
//	Metodos sets y gets para los atributos de la clase Mozo
//	-------------------------------------------------------------	
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
	
	public boolean isHabilitado (){
		return habilitado;
	}
	
	public void setNoHabilitado (){
		habilitado = false;
	}
	
	public void setNombre (String Nombre){
		nombre = Nombre;
	}

	//	Metodo get que devuelve un MozoView para pasar a la vista
	public MozoView getMozoView(){
		MozoView mv = new MozoView(id, nombre, comision, habilitado);
		return mv;
	}
	
}