public class Enemigo extends Personaje_Ataca implements Ataque {
	
	/******** Metodo: Enemigo ********************
Descripcion: Constructor del enemigo
Parametros:
vida inicial entero
ataque entero
defensa entero
Retorno: el enemigo
************************************************/
	public Enemigo (int vida_inicial, int ataque_inicial, int defensa_inicial ) {
		super(vida_inicial, ataque_inicial, defensa_inicial,"malo");
		 
	}
/******** Metodo: enemigo ********************
Descripcion: genera enemigo con cambios
Parametros:
enemigo auxiliar
Retorno: el enemigo con cambios
************************************************/
	public Enemigo(Enemigo aux) {
		super(aux.vida_actual,aux.ataque_base,aux.defensa_base,"malo");
	}
/******** Metodo: vida_actual_enAtaque ********************
Descripcion: retorna la vida actual del enemigo en pelea
Retorno: retorna la vida mas la defensa
************************************************/
	public int vida_actual_enAtaque() {
		return vida_actual+defensa_base;
	}
	/******** Metodo: vida_actual_IO ********************
Descripcion: retorna la vida en modo pasivo
Retorno: retorna la vida en modo pasivo
************************************************/
	public int vida_actual_IO() {
		return vida_actual;
	}
	public int cambio_vida(int ataque) {
		int cambio_vida;
		cambio_vida = vida_actual_enAtaque() - ataque;
		
		if(cambio_vida<0) {
			cambio_vida=0;
		}
		if(cambio_vida > vida_actual) {
			return vida_actual;
		}
		vida_actual=cambio_vida;
		return cambio_vida;
	}
/******** Metodo: Atacar ********************
Descripcion: ataca
Retorno: retorna su ataque
************************************************/
	public int Atacar() {
		return ataque_base;
	}
	
/******** Metodo: toString ********************
Descripcion: retorna los datos del enemigo
Retorno: retorna los datos del enemigo
************************************************/
	public String toString() {
		return vida_actual +" "+ ataque_base +" "+ defensa_base;
	}
	
}
	
