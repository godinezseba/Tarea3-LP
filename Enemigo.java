public class Enemigo extends Personaje_Ataca implements Ataque {
	
	public Enemigo (int vida_inicial, int ataque_inicial, int defensa_inicial ) {
		super(vida_inicial, ataque_inicial, defensa_inicial,"malo");
		 
	}
	
	public int vida_actual_enAtaque() {
		return vida_actual+defensa_base;
	}
	public int vida_actual_IO() {
		return vida_actual;
	}
	public int cambio_vida(int ataque) {
		int cambio_vida;
		cambio_vida = vida_actual_enAtaque() - ataque;
		if(cambio_vida<0) {
			cambio_vida=0;
		}
		vida_actual=cambio_vida;
		return cambio_vida;
	}
	public int Atacar() {
		return ataque_base;
	}
	
	public String toString() {
		return vida_actual +" "+ ataque_base +" "+ defensa_base;
	}
	
}
	
