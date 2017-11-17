public class Nivel{
	
	String Nombre_nivel;
	int Mundo[];
	Jugador campeon;
	Jefe darth_vader;
	Aliado morty;
	Enemigo lucho_jara;
	Objeto obj_nivel;
	
	public Nivel(String nombre_asignado){
		Nombre_nivel=nombre_asignado;
	}
	public void crear_jugador(String nombre_jugador, int vida_base_jugador, int Ataque_base, int defensa_base,int pp1, int pp2, int bonus1, int bonus2,Objeto objeto_inicial ) {
		campeon= new Jugador(vida_base_jugador,Ataque_base,defensa_base , nombre_jugador, pp1,  pp2,  bonus1, bonus2);
		campeon.agregar_objeto(objeto_inicial);
		
	}	
	public void crear_villano(int vida_incial, int ataque_inicial, int defensa_inicial, int ataque_2, String nombre) {
		darth_vader= new Jefe(vida_incial,ataque_inicial,defensa_inicial,ataque_2,nombre);
	}
	public void crear_aliado(int vida_inicial,Objeto objeto_inicial) {
		morty= new Aliado(vida_inicial,objeto_inicial);
		campeon.agregar_objeto(objeto_inicial);
	}
	public void crear_objeto_nivel(int valor, String ntipo) {
		obj_nivel= new Objeto(valor,ntipo);
	}
	public void crear_enemigo(int vida_inicial, int ataque_inicial, int defensa_inicial) {
		lucho_jara= new Enemigo(vida_inicial,ataque_inicial,defensa_inicial);
	}
	
}