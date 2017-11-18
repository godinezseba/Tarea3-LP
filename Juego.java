import java.util.Scanner;
public class Juego{
	
	
	static Nivel cuarta_dimension; //variable auxiliar para la creacion de niveles
	static int  opcion=-1; // variable para las opciones del menu
	static Scanner terminal; //scanner IO
	
	private static Objeto crear_objeto() {
		Objeto auxObjt;
		int opobjt,auxobjt;
		//Seleccion del Objeto
		System.out.println("Elija un Objeto: \n"
				+ "1. Vida\n"
				+ "2. Ataque\n"
				+ "3. Defensa\n");
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
		System.out.print("Vida Base del Jugador: ");
		auxvida = terminal.nextInt();
		System.out.print("Ataque Base del Jugador: ");
		auxataque = terminal.nextInt();
		System.out.print("Defensa Base del Jugador: ");
		auxdefensa = terminal.nextInt();
		cuarta_dimension.crear_enemigo(auxvida,auxataque,auxdefensa, cant);
	}
	
	public static void main (String [ ] args) {
		
	System.out.println("----------- Simulador de Niveles ---------------");
	
	terminal = new Scanner (System.in);
	
		while(opcion!=4) {
			
			System.out.println("1. Crear Niveles");
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
				// primero ingresa el nombre del nivel
				System.out.print("Nombre del Nivel: ");
				String auxname = terminal.next();
				cuarta_dimension = new Nivel(auxname);
				
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
			}
			//System.out.println(cuarta_dimension);
		}
	}
}