import java.util.LinkedList;
import java.util.Random;
public class Jugador extends Personaje_Ataca implements Ataque{
	String Nombre;
	LinkedList objetos;
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
		objetos = new LinkedList();
		ataque_especial1 = new  int[2];
		ataque_especial2 = new  int[2];
		ataque_especial1[0]=pp1;
		ataque_especial1[1]=bonus1;
		ataque_especial2[0]=pp2;
		ataque_especial2[1]=bonus2;
	}
	/**Agrega el objeto ingresado al jugador.*/
	public void agregar_objeto(Objeto nuevo) {
		objetos.add(nuevo);
	}
	/**Elimina el objeto dado al Jugador, si no esta no pasa nada.*/
	public void eliminar(Objeto pormatar) {
		objetos.remove(pormatar);
	}
	/**Retorna la vida del Jugador mas toda la vida extra por los objetos y la defensa*/
	public int vida_actual_enAtaque(){
		int suma_vida = 0;
		Objeto aux;
		// agrego los stats dados por los objetos
		for(int i; i < objetos.size(); i++) {
			aux = objetos.get();
			if(aux.tipo() == "vida" || aux.tipo() == "defensa") // si el objeto es de vida o defensa lo agrego
				suma_vida += aux.Bonus();
		}
		suma_vida += vida_actual + defensa_base;
		return suma_vida;
	}
	public int vida_actual_IO() {
		return vida_actual;
	}
	/** voy a asumir que la defensa base es constante y que lo primero que resto son la vida de los objetos, 
	 * si esta llega a 0 elimino el objeto en cuestion, luego resto el valor del ataque con la defensa 
	 * (esta no se ve afectada) y al final lo que queda se lo resto a la vida base*/
	public int cambio_vida(int ataque) {
		int cambio_vida;
		cambio_vida = vida_actual_enAtaque() - ataque;
		return cambio_vida;
	}
	public int Atacar(){
		int ataque = 0;
		Objeto aux;
		for(int i; i < objetos.size(); i++) {
			aux = objetos.get();
			if(aux.tipo() == "ataque") // si el objeto es de ataque lo agrego
				ataque += aux.Bonus();
		}
		ataque += ataque_base;
		return ataque;
	}
	 public int Atacar_Especial() {
		int aleatorio =  Random(1,2)*(2-1) + 1; // vemos de forma "aleatoria 
		int ataque = 0;
		
		if(aleatorio == 1 && ppactual >= ataque_especial1[0]) {
			ppactual -= ataque_especial1[0];
			ataque += ataque_especial1[1];
		}
		else if(aleatorio == 2 && ppactual >= ataque_especial2[0]) {
			ppactual -= ataque_especial2[0];
			ataque += ataque_especial2[1];
		}
		ataque +=Atacar();
		return ataque;
	}
}
