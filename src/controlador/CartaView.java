package controlador;

public class CartaView {
	private String dia;

//	Constructor de instancia Carta
//	-------------------------------------------------------------	
	public CartaView (String day){
		this.dia = day;
	}
	
//	Metodo get para los atributos de la clase ItemDeCarta
//	-------------------------------------------------------------	
	public String getDia() {
		return dia;
	}
}
