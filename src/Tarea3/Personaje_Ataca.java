package juego;
public abstract class Personaje_Ataca extends Personaje{
	  public int ataque_base; // el ataque base del Personaje
	  public int defensa_base; // la defensa base dele Personaje
		
	  public Personaje_Ataca(int vida_inicial, int ataque_inicial, int defensa_inicial,String categoria){
	    super(vida_inicial,categoria);
	    ataque_base = ataque_inicial;
	    defensa_base = defensa_inicial;
	  }


}
