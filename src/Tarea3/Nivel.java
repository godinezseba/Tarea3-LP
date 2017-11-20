package juego;
public class Nivel{

	String Nombre_nivel;
	int Mundo[]; //{jugador_vivo ; aliado_vivo ; jefe_vivo ; cant_enemigos}
	Jugador campeon;
	Jefe darth_vader;
	Aliado morty;
	Enemigo lucho_jara;
	Objeto obj_nivel;
	int id;

	public Nivel(String nombre_asignado, int aux){
		Nombre_nivel=nombre_asignado;
		Mundo = new int[4];
		id = aux;
	}
	public void crear_jugador(String nombre_jugador, int vida_base_jugador, int Ataque_base, int defensa_base,int pp1, int pp2, int bonus1, int bonus2,Objeto objeto_inicial ) {
		campeon= new Jugador(vida_base_jugador,Ataque_base,defensa_base , nombre_jugador, pp1,  pp2,  bonus1, bonus2,objeto_inicial);
		Mundo[0] = 1;

	}
	public void crear_villano(int vida_incial, int ataque_inicial, int defensa_inicial, int ataque_2, String nombre) {
		darth_vader= new Jefe(vida_incial,ataque_inicial,defensa_inicial,ataque_2,nombre);
		Mundo[2] = 1;
	}
	public void crear_aliado(int vida_inicial,Objeto objeto_inicial) {
		morty= new Aliado(vida_inicial,objeto_inicial);
		Mundo[1] = 1;
	}
	public void crear_objeto_nivel(Objeto objeto) {
		obj_nivel= objeto;
	}
	public void crear_enemigo(int vida_inicial, int ataque_inicial, int defensa_inicial, int cantidad) {
		lucho_jara= new Enemigo(vida_inicial,ataque_inicial,defensa_inicial);
		Mundo[3] = cantidad;
	}
	public void reset_Mundo() {
		Mundo[0] = 1;
		Mundo[1] = 1;
		Mundo[2] = 1;
	}
	public String StringName() {
		return id + ". " + Nombre_nivel;
	}
	public String toString() {
		return Nombre_nivel + "\n" + campeon + "\n" + darth_vader +"\n" + morty + "\n" + obj_nivel + "\n" + Mundo[3] + lucho_jara ;
	}
	public String StringAmigable() {
		return "Nombre del Jugador: " + campeon.Nombre + " \n" +
				"Vida Base del Jugador: " + campeon.vida_actual + " \n" +
				"Ataque Base del Jugador: " + campeon.ataque_base +  " \n" +
				"Defensa Base del Jugador: " + campeon.defensa_base +" \n" +
				"Informacion Ataques Especiales: \n" +
				"Primer A.E.: Ataque: " + campeon.ataque_especial1[1] + " PP: " + campeon.ataque_especial1[0] + " \n" +
				"Segundo A.E.: Ataque: " + campeon.ataque_especial2[1] + " PP: " + campeon.ataque_especial2[0] + " \n" +
				"Informacion Objeto(Opcional): Tipo: " + campeon.inicial.tipo() + " Bonus: " + campeon.inicial.Bonus() + " \n" +
				"Nombre del Jefe: " + darth_vader.Nombre + " \n" +
				"Vida Base del Jugador: " + darth_vader.vida_actual + " \n" +
				"Ataque Base del Jugador: " + darth_vader.ataque_base +  " \n" +
				"Defensa Base del Jugador: " + darth_vader.defensa_base +" \n" +
				"Informacion Ataque Especial: Ataque: " + darth_vader.ataque_especial + " \n" +
				"Vida Base del Aliado: " + morty.vida_actual + " \n" +
				"Informacion Objeto: Tipo: " + morty.objeto1.tipo() + " Bonus: " + morty.objeto1.Bonus() + " \n" +
				"Cantidad de Enemigos: " + Mundo[3] + " \n" +
				"Vida Base de Enemigos: " + lucho_jara.vida_actual + " \n" +
				"Ataque Base de Enemigos: " + lucho_jara.ataque_base + " \n" +
				"Defensa Base de Enemigos: " + lucho_jara.defensa_base + " \n" +
				"Fin Informacion";
	}
}
