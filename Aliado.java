public class Aliado extends Personaje {
	
	Objeto objeto1;
	/******** Metodo: Aliado ********************
Descripcion: Constructor de Aliado
Parametros:
vida inicial
objeto que porta el aliado
Retorno: El aliado
************************************************/
	public Aliado (int vida_inicial,Objeto objeto_inicial ) {
		super(vida_inicial,"bueno");
		objeto1 = new Objeto(objeto_inicial);
	}
	/******** Aliado ********************
Descripcion: Se modifican los datos al Aliado
Parametros:
Un aliado temporal
Retorno: Aliado con valores modificados
************************************************/
	public Aliado(Aliado aux) {
		super(aux.vida_actual , aux.Tipo);
		objeto1 = new Objeto(aux.objeto1);
	}
	/******** Metodo: bono:jugador ********************
Descripcion: retorna el bojeto del aliado para aplicarse el bono sobre el jugador
Parametros:
El objeto
Retorno: el objeto
************************************************/
	public Objeto bono_jugador() {
		return objeto1;
	}
	/******** Metodo: vida_actual_enAtaque ********************
Descripcion: retorna la vida actual del aliado

Retorno: la vida actual del aliado
************************************************/
	public int vida_actual_enAtaque() {
		return vida_actual;
	}
/******** Metodo: vida_actual_IO ********************
Descripcion: retorna la vida actual del aliado

Retorno: retorna la vida del aliado
************************************************/	
	public int vida_actual_IO() {
		return vida_actual;
	}
	/******** Metodo: cambio_vida********************
Descripcion: aplica el danno del ataque a la vida del aliado
Parametros:
ataque entero

Retorno:la vida con el danno restado
************************************************/
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
