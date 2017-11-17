public class Aliado extends Personaje {
	int defensa_objeto;
	int ataque_objeto;
	int vida_objeto;
	Objeto objeto1;
	public Aliado (int vida_inicial,Objeto objeto_inicial ) {
		super(vida_inicial,"bueno");
		objeto1=objeto_inicial;
	}
	
	public Objeto bono_jugador() {
		return objeto1;
	}
	
	
	
}
