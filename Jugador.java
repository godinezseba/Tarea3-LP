import java.lang.Math;
public class Jugador extends Personaje_Ataca implements Ataque{
	String Nombre;
	int[] ataque_especial1; // Ataque Especial 1, [pp, ataque] 
	int[] ataque_especial2; // Ataque Especial 2, [pp, ataque]
	int ppmax; // es el pp maximo que va a tener nuestro personaje
	int ppactual; // pp a que tiene en un momento dado de la pelea
	
	/**Constructor de nuestro jugador, tiene que entregar:
	 * Vida Inicial, Ataque Inicial, Defensa Inicial, Nombre, Ataque Especial 1:pp, bonus
	 * Ataque Especial 2: pp, bonus*/
	public Jugador(int vida_inicial,int ataque_inicial, int defensa_inicial,String Name,int pp1, int pp2, int bonus1, int bonus2){
		super(vida_inicial,ataque_inicial,defensa_inicial,"bueno");
		Nombre = Name;
		
		ataque_especial1 = new  int[2];
		ataque_especial2 = new  int[2];
		
		ataque_especial1[0]=pp1;
		ataque_especial1[1]=bonus1;
		ataque_especial2[0]=pp2;
		ataque_especial2[1]=bonus2;
	}
	/**Agrega el objeto ingresado al jugador, se asigna directamente a la variable que afecta el objeto.*/
	public void agregar_objeto(Objeto nuevo) {
		if(nuevo.tipo() == "ataque")
			ataque_base += nuevo.Bonus();
		else if(nuevo.tipo() == "defensa")
			defensa_base += nuevo.Bonus();
		else if (nuevo.tipo() == "vida")
			vida_actual += nuevo.Bonus();
	}
	/**Elimina el objeto dado al Jugador, si este se aplica a la vida y la vida da <= 0 retorna True haciendo referencia que murio
	 * en cualquier otro caso retorna False.*/
	public Boolean eliminar_objeto(Objeto pormatar) {
		if(pormatar.tipo() == "ataque")
			ataque_base -= pormatar.Bonus();
		else if(pormatar.tipo() == "defensa")
			defensa_base -= pormatar.Bonus();
		else if (pormatar.tipo() == "vida")
			vida_actual -= pormatar.Bonus();
		if(vida_actual <= 0)
			return true; // retorna True si el Jugador muere por perder el objeto
		else
			return false; // retorna False si el Jugador no muere por perder el objeto
	}
	/**Retorna la vida del Jugador mas toda la vida extra por los objetos y la defensa*/
	public int vida_actual_enAtaque(){
		return vida_actual + defensa_base;
	}
	/**Retorna la vida base del Jugador, sin importar la defensa*/
	public int vida_actual_IO() {
		return vida_actual;
	}
	/**Retorna la vida resultante de hacer sido atacado el personaje, esto se aplica directamente en el Jugador*/
	public int cambio_vida(int ataque) {
		int cambio_vida;
		cambio_vida = vida_actual_enAtaque() - ataque;
		if(cambio_vida<0) 
			cambio_vida=0;
		vida_actual=cambio_vida;
		return cambio_vida;
	}
	/**Retorna el ataque base del Jugador*/
	public int Atacar(){
		return ataque_base;
	}
	/**Primero se elige entre uno de los 2 ataques, se ve si tiene los suficientes pp para usarlo y se retorna el valor del ataque,
	 * mas el valor del ataque base*/
	public int Atacar_Especial() {
		int ataque = 0;
		int aleatorio = ((int) (Math.random()*(101)))%2;
		if(aleatorio == 1 && ppactual >= ataque_especial1[0]) {
			ppactual -= ataque_especial1[0];
			ataque += ataque_especial1[1];
		}
		else if(aleatorio == 0 && ppactual >= ataque_especial2[0]) {
			ppactual -= ataque_especial2[0];
			ataque += ataque_especial2[1];
		}
		ataque +=Atacar();
		return ataque;
	}
	/**Quiero que tenga la forma dada para el .txt*/
	 public String ToString() {
		 return Nombre +" "+ vida_actual +" "+ ataque_base +" "+ defensa_base +" "+ataque_especial1[0]+";"+ataque_especial1[1]+" "+ataque_especial2[0]+";"+ataque_especial2[1] ;
	 }
}
