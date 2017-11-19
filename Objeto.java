public class Objeto {
	private int bonus;
	private String tipo; // se especifica si es a la vida, ataque o defensa "vida", "ataque", "defensa"
	
	public Objeto(int valor, String ntipo) {
		bonus = valor;
		tipo = ntipo;
	}
	public Objeto(Objeto aux){
		bonus = aux.Bonus();
		tipo = aux.tipo();		
	}
	public void cambiar_Bonus(int i) {
		bonus = i;
	}
	public void cambiar_tipo(String i) {
		tipo = i;
	}
	/** Retorna de que tipo es el bonus en cuestion.*/
	public String tipo() {
		return tipo;
	}
	/**Retorna el valor del bonus.*/
	public int Bonus() {
		return bonus;
	}
	public String toString() {
		return tipo+" "+bonus;
	}
}
