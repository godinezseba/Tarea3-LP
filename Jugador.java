public class Jugador extends Personaje_Ataca{
	String Nombre;
	Objeto cant_objt[];
	public Jugador(int vida_inicial,int ataque_inicial, int defensa_inicial){
		super(vida_inicial,ataque_inicial,defensa_inicial,"bueno");
	}
	public int vida_actual_enAtaque() {
		return 0;
	}
	public int vida_actual_IO() {
		return vida_actual;
	}
	public int cambio_vida(int ataque) {
		int cambio_vida;
		cambio_vida = vida_actual_enAtaque() - ataque;
		return cambio_vida;
	}
}
