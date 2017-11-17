
public class Jefe extends Personaje_Ataca{
	String Nombre;
	int ataque_especial; //es el ataque especial que puede poseer
	
	public Jefe(int vida_inicial,int ataque_inicial, int defensa_inicial,String Name){
		super(vida_inicial,ataque_inicial,defensa_inicial,"bueno");
		Nombre = Name;
	}
	
}
