public class Aliado extends Personaje {

	Objeto objeto1;
	public Aliado (int vida_inicial,Objeto objeto_inicial ) {
		super(vida_inicial,"bueno");
		objeto1 = new Objeto(objeto_inicial);
	}
	public Aliado(Aliado aux) {
		super(aux.vida_actual , aux.Tipo);
		objeto1 = new Objeto(aux.objeto1);
	}
	public Objeto bono_jugador() {
		return objeto1;
	}
	public int vida_actual_enAtaque() {
		return vida_actual;
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
	public String toString() {
		return vida_actual + " " + objeto1;
	}
		
}