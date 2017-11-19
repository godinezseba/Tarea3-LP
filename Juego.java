import java.util.Scanner;
import java.lang.Math;

public class Juego{
	
	
	static Nivel cuarta_dimension; //variable auxiliar para la creacion de niveles
	static Nivel []portal_dimensional; // arreglo que contendra todos los Niveles guardados
	static int cant_niveles; // cantidad de niveles cargados
	static int  opcion=-1; // variable para las opciones del menu
	static Scanner terminal; //scanner IO
	
	private static Objeto crear_objeto() {
		Objeto auxObjt;
		int opobjt,auxobjt;
		//Seleccion del Objeto
		System.out.println("Elija un Objeto: \n"
				+ "1. Vida\n"
				+ "2. Ataque\n"
				+ "3. Defensa");
		System.out.print("Elegir: ");
		opobjt = terminal.nextInt();
		while((opobjt > 3 || opobjt < 1)) { // revisa que sea una opcion valida
			System.out.println("Opcion Invalida!,");
			System.out.print("Por favor ingrese otra opcion: ");
			opobjt = terminal.nextInt();
		}

		switch(opobjt) {
		case 1:
			System.out.print("Bonus de Vida: ");
			auxobjt = terminal.nextInt();
			auxObjt = new Objeto(auxobjt,"vida");
			break;
		case 2:
			System.out.print("Bonus de Ataque: ");
			auxobjt = terminal.nextInt();
			auxObjt = new Objeto(auxobjt,"ataque");
			break;
		case 3:
			System.out.print("Bonus de Defensa: ");
			auxobjt = terminal.nextInt();
			auxObjt = new Objeto(auxobjt,"defensa");
			break;
		default:
			auxObjt = new Objeto(0,"");
		}
		return auxObjt;
	}
	
	private static void crear_jugador() {
		String nombreaux;
		int auxvida,auxataque,auxdefensa,auxpp1,auxpp2,auxbonus1,auxbonus2; // variables que se asignaran al jugador
		int op1,op2; // opciones de armas especiales
		Objeto auxObjt;
		int opobjt,auxobjt;
		System.out.print("Nombre del Jugador: ");
		nombreaux = terminal.next();
		System.out.print("Vida Base del Jugador: ");
		auxvida = terminal.nextInt();
		System.out.print("Ataque Base del Jugador: ");
		auxataque = terminal.nextInt();
		System.out.print("Defensa Base del Jugador: ");
		auxdefensa = terminal.nextInt();
		System.out.println("Eleja 2 Ataques Especiales:\n"
				+ "(Recuerde que tiene 50 el Jugador.) \n"
				+ "1. S.D.M.G.    +77 ataque, 10 pp\n"
				+ "2. Terra Blade +95 ataque, 15 pp\n"
				+ "3. Last Prism +100 ataque, 18 pp\n"
				+ "4. Star Wrath +110 ataque, 20 pp");
		// Seleccion del Primer Ataque Especial
		System.out.print("Elegir: ");
		op1 = terminal.nextInt();
		while(op1 > 4 || op1 < 1) { // revisa que sea una opcion valida
			System.out.println("Opcion Invalida!,");
			System.out.print("Por favor ingrese otra opcion: ");
			op1 = terminal.nextInt();
		}
		switch(op1) { // Asignacion de valores
		case 1:
			auxpp1 = 10;
			auxbonus1 = 77;
			break;
		case 2:
			auxpp1 = 15;
			auxbonus1 = 95;
			break;
		case 3:
			auxpp1 = 18;
			auxbonus1 = 100;
			break;
		case 4:
			auxpp1 = 20;
			auxbonus1 = 110;
			break;
		default:
			auxpp1 = 0;
			auxbonus1 = 0;
		}
		// Seleccion del Segundo Ataque Especial
		System.out.print("Elegir: ");
		op2 = terminal.nextInt();
		while((op2 > 4 || op2 < 1) || op2 == op1) { // revisa que sea una opcion valida
			System.out.println("Opcion Invalida!,");
			System.out.print("Por favor ingrese otra opcion: ");
			op2 = terminal.nextInt();
		}
		switch(op2) {
		case 1:
			auxpp2 = 10;
			auxbonus2 = 77;
			break;
		case 2:
			auxpp2 = 15;
			auxbonus2 = 95;
			break;
		case 3:
			auxpp2 = 18;
			auxbonus2 = 100;
			break;
		case 4:
			auxpp2 = 20;
			auxbonus2 = 110;
			break;
		default:
			auxpp2 = 0;
			auxbonus2 = 0;
		}
		//Seleccion del Objeto
		System.out.println("Elija un Objeto: \n"
				+ "1. Vida\n"
				+ "2. Ataque\n"
				+ "3. Defensa\n"
				+ "4. Ninguno");
		System.out.print("Elegir: ");
		opobjt = terminal.nextInt();
		while((opobjt > 4 || opobjt < 1)) { // revisa que sea una opcion valida
			System.out.println("Opcion Invalida!,");
			System.out.print("Por favor ingrese otra opcion: ");
			opobjt = terminal.nextInt();
		}

		switch(opobjt) {
		case 1:
			System.out.print("Bonus de Vida: ");
			auxobjt = terminal.nextInt();
			auxObjt = new Objeto(auxobjt,"vida");
			break;
		case 2:
			System.out.print("Bonus de Ataque: ");
			auxobjt = terminal.nextInt();
			auxObjt = new Objeto(auxobjt,"ataque");
			break;
		case 3:
			System.out.print("Bonus de Defensa: ");
			auxobjt = terminal.nextInt();
			auxObjt = new Objeto(auxobjt,"defensa");
			break;
		default:
			auxObjt = new Objeto(0,"");
		}
		cuarta_dimension.crear_jugador(nombreaux,auxvida,auxataque,auxdefensa,auxpp1,auxpp2,auxbonus1,auxbonus2,auxObjt);
	}
	
	private static void crear_jefe() {
		String nombreaux;
		int auxvida,auxataque,auxdefensa,auxbonus1; // variables que se asignaran al jefe
		int op1; // opcion de arma especial

		System.out.print("Nombre del Jefe: ");
		nombreaux = terminal.next();
		System.out.print("Vida Base del Jefe: ");
		auxvida = terminal.nextInt();
		System.out.print("Ataque Base del Jefe: ");
		auxataque = terminal.nextInt();
		System.out.print("Defensa Base del Jefe: ");
		auxdefensa = terminal.nextInt();
		System.out.println("Elija un Ataque Especial:\n"
				+ "1. Paty Maldonado  +60 ataque, 420 pp\n"
				+ "2. Karol Dance     +90 ataque, 420 pp");
		
		// Seleccion del Ataque Especial
		System.out.print("Elegir: ");
		op1 = terminal.nextInt();
		while(op1 > 2 || op1 < 1) { // revisa que sea una opcion valida
			System.out.println("Opcion Invalida!,");
			System.out.print("Por favor ingrese otra opcion: ");
			op1 = terminal.nextInt();
		}
		switch(op1) { // Asignacion de valores
		case 1:
			auxbonus1 = 60;
			break;
		case 2:
			auxbonus1 = 90;
			break;
		default:
			auxbonus1 = 0;
		}
		cuarta_dimension.crear_villano(auxvida,auxataque,auxdefensa,auxbonus1,nombreaux);
	}
	
	private static void crear_aliado() {
		int auxvida; //variables que se asignan al aliado
		
		System.out.print("Vida Base del Aliado: ");
		auxvida = terminal.nextInt();
		
		cuarta_dimension.crear_aliado(auxvida, crear_objeto());
	}
	
	private static void crear_enemigos() {
		int auxvida,auxataque,auxdefensa;
		int cant;
		System.out.print("Ingrese la cantidad de Enemigos: ");
		cant = terminal.nextInt();
		while(cant < 1) { // revisa que sea una opcion valida
			System.out.println("Opcion Invalida!,");
			System.out.print("Por favor ingrese otra opcion: ");
			cant = terminal.nextInt();
		}
		System.out.print("Vida Base del Jugador: ");
		auxvida = terminal.nextInt();
		System.out.print("Ataque Base del Jugador: ");
		auxataque = terminal.nextInt();
		System.out.print("Defensa Base del Jugador: ");
		auxdefensa = terminal.nextInt();
		cuarta_dimension.crear_enemigo(auxvida,auxataque,auxdefensa, cant);
	}
	
	private static void simulacion(Nivel matrix) {
		// variables para la simulacion
		String peleo; // un string para saber contra quien esta peleando nuestro jugador
		boolean en_pelea = false, objt_encontrado = false; // el primero es para saber si esta en pelea, el segundo para saber si ya encontro el objeto
		int random_objt,random_enemigo; // es para ver la aleatoriedad de encontrar el objeto de nivel
		int enemigos_derrotados = 0; //la cantidad de enemigos q a matado el jugador
		// variables temporales para la simulacion
		Jugador temp_jugador = new Jugador(matrix.campeon); 
		Aliado temp_aliado = new Aliado(matrix.morty); 
		Jefe temp_jefe = new Jefe(matrix.darth_vader);
		
		//aca agrego idNivel y nombreNivel AL ARCHIVO
		//aca indico que la simulacion partio en EL ARCHIVO
		System.out.println("Comienzo!");
		temp_jugador.agregar_objeto(matrix.morty.objeto1);
		temp_jugador.agregar_objeto(temp_jugador.inicial);
		while(matrix.Mundo[0] != 0 || matrix.Mundo[2] != 0) {
			if (en_pelea){ // si esta en pelea aca se ve eso
				
			}
			else { // si no esta en pelea entramos aca
				if(objt_encontrado == false) { // si aun no encuentra el objeto vemos si existe la posibilidad de q lo encuentra
					random_objt = (int) (Math.random()*(10)); 
					if(random_objt == 1) { // una probabilidad del 10% de que encuentre el objeto
						//aca indica que encontro el objeto en EL ARCHIVO
						System.out.println("Jugador encontro el Objeto de Nivel!");
						temp_jugador.agregar_objeto(matrix.obj_nivel);
						objt_encontrado = true;
					}
				}
				// una vez visto eso veremos contra quien peleara nuestro heroe..
				random_enemigo = (int) (Math.random()*(matrix.Mundo[3] - enemigos_derrotados + 1)); // la probabilidad de pelear contra el jefe sera entre 1 : cant_enemigos
				if(random_enemigo == 0) {
					peleo = "jefe";
					System.out.println("Jugador se encontra con el Jefe!");
					// guardo que pelee contra el jefe en EL ARCHIVO
				}
				else { // notar que si ya mate a todos los enemigos si o si entra en jefe
					Enemigo temp_enemigo = new Enemigo(matrix.lucho_jara); // creo a nuestro enemigo temporal
					peleo = "enemigo";
					System.out.println("Jugador se encuentra con Enemigo" + (enemigos_derrotados + 1 ));
					// guardo que pelee contra un enemigo en EL ARCHIVO
					
				}
			}
		}
	}
	
	public static void main (String [ ] args) {
		portal_dimensional = new Nivel[100];
		cant_niveles = 0; // como aun no se lee el archivo partimos con 0 niveles creados
		// aca deberia ir la funcion que lee el archivo niveles
		System.out.println("----------- Simulador de Niveles ---------------");
		
		terminal = new Scanner (System.in);
		
			while(opcion!=4) {
				
				System.out.println("\n1. Crear Niveles");
				System.out.println("2. Simular cambios en Nivel");
				System.out.println("3. Consultar información de Nivel");
				System.out.println("4. Salir");
				System.out.print("Ingrese una opcion: ");
				opcion = terminal.nextInt(); // elige una opcion
				
				while(opcion > 4 || opcion < 1) { // revisa que sea una opcion valida
					System.out.println("Opcion Invalida!,");
					System.out.print("Por favor ingrese otra opcion: ");
					opcion = terminal.nextInt();
				}
				
				if(opcion == 1) {
					// primero ingresa el nombre del nivel y su id
					cant_niveles += 1;
					System.out.print("Nombre del Nivel: ");
					String auxname = terminal.next();
					cuarta_dimension = new Nivel(auxname, cant_niveles);
					
					// creo el resto
					System.out.println("-------- Creacion de Jugador --------");
					crear_jugador();
					System.out.println("--------- Creacion de Jefe ----------");
					crear_jefe();
					System.out.println("-------- Creacion de Aliado ---------");
					crear_aliado();
					System.out.println("---- Creacion de Objeto de Nivel ----");
					cuarta_dimension.crear_objeto_nivel(crear_objeto());
					System.out.println("------- Creacion de Enemigos --------");
					crear_enemigos();
					
					portal_dimensional[cant_niveles-1] = cuarta_dimension;
					
				}
				else if(opcion == 2) {
					if(cant_niveles == 0) {
						System.out.println("Aun no crean Niveles!");
					}
					else {
						int choice_lvl;
						for(int i = 0; i < cant_niveles ; i++) {
							System.out.print(portal_dimensional[i].StringName() + " "); ;
						}
						System.out.print("Elegir: ");
						choice_lvl = terminal.nextInt();
						while(choice_lvl > cant_niveles || choice_lvl < 1) { // revisa que sea una opcion valida
							System.out.println("Opcion Invalida!,");
							System.out.print("Por favor ingrese otra opcion: ");
							choice_lvl = terminal.nextInt();
						}
						simulacion(portal_dimensional[choice_lvl-1]);// aca se llama a la funcion simulacion
					}
				}
			}
	}
}