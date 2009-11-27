package modelo;

import controlador.MozoView;

public class Mozo {
	private String nombre;
	private int id;
	private int comision;
	private float liquidacion;
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
	
//	Metodo get que devuelve un MozoView para pasar a la vista
//	-------------------------------------------------------------	
	public MozoView getMozoView(){
		MozoView mv = new MozoView(id, nombre, comision, habilitado, liquidacion);
		return mv;
	}


//	Metodos sets y gets para los atributos de la clase Mozo
//	-------------------------------------------------------------	
	public void setHabilitado (boolean hab){
		habilitado = hab;
	}
	public boolean isHabilitado (){
		return habilitado;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}
	public float getComision() {
		return comision;
	}

	public void setNombre (String Nombre){
		nombre = Nombre;
	}

	public void setLiquidacion(float liquidacion) {
		this.liquidacion = liquidacion;
	}

	public int getId(){
		return id;
	}

}
