import java.util.Vector;

public class MozoView {
	private String nombre;
	private int idMozo;
	private float comision; //o la guardamos como entero
	private float liquidacion;
	//private boolean habilitado = false;
	
	public MozoView (int idMozo, String nombre, float comision)
	{
		super();
		this.idMozo = idMozo;
		this.nombre = nombre;	
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

/*	public boolean getHabilitado (){
		return habilitado;
	}
*/
}
