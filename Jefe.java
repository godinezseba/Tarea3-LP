public class Jefe extends Personaje_Ataca implements Ataque, AtaqueEspecial {
	String Nombre;
	int ataque_especial; //es el ataque especial que puede poseer
	
	public Jefe(int vida_inicial,int ataque_inicial, int defensa_inicial, int ataque_2,String Name){
		super(vida_inicial,ataque_inicial,defensa_inicial,"malo");
		Nombre = Name;
		ataque_especial=ataque_2;
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
	public int Atacar_Especial() {
		return ataque_base+ataque_especial;
	}
	public String ToString() {
		 return Nombre +" "+ vida_actual +" "+ ataque_base +" "+ defensa_base +" "+ataque_especial;
	}
}