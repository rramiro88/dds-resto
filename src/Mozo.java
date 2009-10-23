public class Mozo {
	private String nombre;
	private int idMozo;
	private float comision; //o la guardamos como entero
	private float liquidacion;
	private boolean habilitado = false;
	
	public Mozo (String nombre, int idMozo, float comision)
	{
		super();
		this.nombre = nombre;
		this.idMozo = idMozo;
		this.comision = comision;
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

	public void setComision(float comision) {
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
