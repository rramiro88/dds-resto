//	Esta es una subida y cambios realizados desde una 
//	bajada y subida desde otra pc	-	BORRAR

public class MozoView {
	private String nombre;
	private int idMozo;
	private float comision; //o la guardamos como entero
	private float liquidacion;
	private boolean habilitado = false;
	
	public MozoView (String nombre, int idMozo, float comision)
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
	
/*	public float getLiquidacion()
	{
		return liquidacion;
	}
*/
	public float getComision() {
		return comision;
	}

	public boolean getHabilitado (){
		return habilitado;
	}
	
}
