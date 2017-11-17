public class Jugador extends Personaje_Ataca{
	String Nombre;
	Objeto cant_objt[];
	int ataque_especial1[]; // Ataque Especial 1, [pp, ataque] 
	int ataque_especial2[]; // Ataque Especial 2, [pp, ataque]
	public Jugador(int vida_inicial,int ataque_inicial, int defensa_inicial,String Name){
		super(vida_inicial,ataque_inicial,defensa_inicial,"bueno");
		Nombre = Name;
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
