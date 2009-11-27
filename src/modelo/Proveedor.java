package modelo;

import controlador.ProveedorView;

public class Proveedor {
	private String cuit;
	private String razonsocial;
	private String domicilio;
	
	
//	Constructor de instancia Proveedor
//	-------------------------------------------------------------	
	public Proveedor (String cuit, String razonsocial, String domicilio){
		this.cuit = cuit;
		this.razonsocial = razonsocial;
		this.domicilio = domicilio;
	}
	
//	Metodo get que devuelve un ProveedorView para pasar a la vista
//	-------------------------------------------------------------	
	public ProveedorView getProveedorView(){
		ProveedorView pv = new ProveedorView(cuit, razonsocial, domicilio);
		return pv;
	}

	
//	Metodos sets y gets para los atributos de la clase Proveedor
//	-------------------------------------------------------------		
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getCuit() {
		return cuit;
	}
	
}
