public class Objeto {
	int bonus;
	String tipo; // se especifica si es a la vida, ataque o defensa "vida", "ataque", "defensa"
	
	public Objeto(int valor, String ntipo) {
		bonus = valor;
		tipo = ntipo;
	}
	public cambiar_Bonus() {
		
	}
	/** Retorna de que tipo es el bonus en cuestion.*/
	public String tipo() {
		return tipo;
	}
	/**Retorna el valor del bonus.*/
	public int Bonus() {
		return bonus;
	}
	public String ToString() {
		return tipo+bonus;
	}
}
