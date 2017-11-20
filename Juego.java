import java.util.Scanner;
import java.lang.Math;
import java.io.*;
public class Juego{
	
	
	static Nivel cuarta_dimension; //variable auxiliar para la creacion de niveles
	static Nivel []portal_dimensional; // arreglo que contendra todos los Niveles guardados
	static int cant_niveles; // cantidad de niveles cargados
	static int  opcion=-1; // variable para las opciones del menu
	static Scanner terminal; //scanner IO
    static FileWriter FP = null; // fichero para escribir en niveles.txt
    static PrintWriter writer = null; // para poder escribir en niveles.txt
	static FileWriter Re = null; // fichero para escribir en registro_simulacion.txt
	static PrintWriter escritor = null; // para escribir en registro

	private static void guardar_Nivel(Nivel matrix) {
    	writer.println(matrix.Nombre_nivel);
    	writer.println(matrix.campeon);
    	writer.println(matrix.darth_vader);
    	writer.println(matrix.morty);
    	writer.println(matrix.obj_nivel);
    	writer.println(matrix.Mundo[3] + " " + matrix.lucho_jara);
    }
	
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
				+ "(Recuerde que tiene 50 pp el Jugador.) \n"
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
			auxObjt = new Objeto(0,"nada");
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
		System.out.print("Vida Base del Enemigo: ");
		auxvida = terminal.nextInt();
		System.out.print("Ataque Base del Enemigo: ");
		auxataque = terminal.nextInt();
		System.out.print("Defensa Base del Enemigo: ");
		auxdefensa = terminal.nextInt();
		cuarta_dimension.crear_enemigo(auxvida,auxataque,auxdefensa, cant);
	}
	
	private static void simulacion(Nivel matrix) {
		// variables para la simulacion:
		String peleo = "",murio = ""; // un string para saber contra quien esta peleando nuestro jugador
		boolean en_pelea = false, objt_encontrado = false; // el primero es para saber si esta en pelea, el segundo para saber si ya encontro el objeto
		// es para ver la aleatoriedad de encontrar el objeto de nivel; encontrar enemigo;quien ataca;a quien ataca 
		int random_objt,random_enemigo,random_ataca,random_a_ataco; 
		int enemigos_derrotados = 0; //la cantidad de enemigos q a matado el jugador
		int daño; //variables utilizadas durante la pelea
		
		// variables temporales para la simulacion
		Jugador temp_jugador = new Jugador(matrix.campeon); 
		Aliado temp_aliado = new Aliado(matrix.morty); 
		Jefe temp_jefe = new Jefe(matrix.darth_vader);
		Enemigo temp_enemigo = null; // lo iniciare cuando pelee contra el y se reseteara por cada pelea
		
		escritor.println(matrix.StringName());//aca agrego idNivel y nombreNivel AL ARCHIVO
		escritor.println("comienzoSimulacion");//aca indico que la simulacion partio en EL ARCHIVO
		
		System.out.println("Comienzo!");
		temp_jugador.agregar_objeto(matrix.morty.objeto1);
		temp_jugador.agregar_objeto(temp_jugador.inicial);
		// aca ocurre la simulacion hasta que el jugador o el jefe muere
		while(matrix.Mundo[0] != 0 && matrix.Mundo[2] != 0) {
			//System.out.println("------\n" + temp_jugador + "\n" + temp_aliado + "\n" + temp_jefe + "\n----------");
			// se tienen 2 estados - > pelea  | no pelea
			if (!en_pelea) { // si no esta en pelea entramos aca
				// como no esta en pelea, reseteare los pp gastados del jugador
				temp_jugador.reset_pp();
				murio = ""; // reseteo quien murio para no tener problemas despues
				if(!objt_encontrado) { // si aun no encuentra el objeto vemos si existe la posibilidad de q lo encuentra
					random_objt = (int) (Math.random()*(5)); 
					if(random_objt == 1) { // una probabilidad del 10% de que encuentre el objeto
						escritor.println("Jugador encontro el Objeto de Nivel");//aca indica que encontro el objeto en EL ARCHIVO
						System.out.println("Jugador encontro el Objeto de Nivel!");
						temp_jugador.agregar_objeto(matrix.obj_nivel);
						objt_encontrado = true;
					}
				}
				// una vez visto eso veremos contra quien peleara nuestro heroe..
				random_enemigo = (int) (Math.random()*(matrix.Mundo[3] - enemigos_derrotados + 1)); // la probabilidad de pelear contra el jefe sera entre 1 : cant_enemigos
				if(random_enemigo == 0) {
					peleo = "jefe"; // esto me servira para saber contra quien pelea el heroe abajo
					escritor.println("Jugador se encuentra con el Jefe");// guardo que pelee contra el jefe en EL ARCHIVO
					System.out.println("Jugador se encuentra con el Jefe!");
				}
				else { // notar que si ya mate a todos los enemigos si o si entra en jefe
					temp_enemigo = new Enemigo(matrix.lucho_jara); // creo a nuestro enemigo temporal
					peleo = "enemigo";
					escritor.println("Jugador se encuentra con Enemigo");// guardo que pelee contra un enemigo en EL ARCHIVO
					System.out.println("Jugador se encuentra con Enemigo " + (enemigos_derrotados + 1 ));
				}
				en_pelea = true;
			}
			// si esta en pelea aca se ve eso
			else { 
				//System.out.println("------\n" + temp_jugador + "\n" + temp_aliado + "\n" + temp_jefe + "\n" + temp_enemigo + "\n----------"); // la uso para ver bugs
				random_ataca = (int) (Math.random()*(3)); // veo la probabilidad de quien ataca
				// entra al if si ataca un malo
				if(random_ataca == 1) { // la probabilidad de que ataque el malo es 1:3 (puede cambiarce)
					random_a_ataco = (int) (Math.random()*(5 * matrix.Mundo[1]));  // quiero que exista mas probabilidad de al aliado que al heroe de 1:5
					// notar que si el aliado muere este resultado siempre sera 0 por lo que siempre atacara al jugador
					if(peleo == "jefe") {
						escritor.print("Jefe ataca ");//aca deberia guardar en EL ARCHIVO
						System.out.print("Jefe ataca ");
						daño = temp_jefe.Probabilidad_Especial(escritor);
					}
					else {
						escritor.print("Enemigo ataca ");//aca deberia guardar en EL ARCHIVO
						System.out.print("Enemigo " + (enemigos_derrotados + 1) +" ataca ");
						daño = temp_enemigo.Atacar();
					}
					if(random_a_ataco == 0) { // ataca al jugador
						escritor.print("Jugador");// aca deberia guardar en EL ARCHIVO
						System.out.print("Jugador"); 
						if (temp_jugador.cambio_vida(daño) == 0) {
							murio = "Jugador";
							matrix.Mundo[0] = 0;
						}
					}
					else {
						escritor.print("Aliado");// aca deberia guardar en El ARCHIVO
						System.out.print("Aliado"); 
						if (temp_aliado.cambio_vida(daño) == 0) {
							murio = "Aliado";
							matrix.Mundo[1] = 0;	
						}
					}
				}
				// en este caso el unico que ataca es el jugador
				else { 
					escritor.print("Jugador ataca ");
					System.out.print("Jugador ataca ");
					daño = temp_jugador.Probabilidad_Especial(escritor);
					if(peleo == "jefe") {
						escritor.print("Jefe");//aca deberia guardar en EL ARCHIVO
						System.out.print("Jefe");
						if (temp_jefe.cambio_vida(daño) == 0) {
							murio = "Jefe";
							matrix.Mundo[2] = 0;
						}
					}
					else {
						escritor.print("Enemigo");//aca deberia guardar en EL ARCHIVO
						System.out.print("Enemigo " + (enemigos_derrotados + 1));
						if (temp_enemigo.cambio_vida(daño) == 0) {
							murio = "Enemigo";
							enemigos_derrotados += 1;
							en_pelea = false;
						}
					}
				}
				escritor.print(", Jugador:" + temp_jugador.vida_actual_IO() + " Aliado:" + temp_aliado.vida_actual_IO() + " ");// aca guardo en EL ARCHIVO la vida
				System.out.print(", Jugador:" + temp_jugador.vida_actual_IO() + " Aliado:" + temp_aliado.vida_actual_IO() + " ");
				// con esta parte muestro la vida del enemigo con el que estoy
				if(peleo == "jefe") {
					escritor.println("Jefe:" + temp_jefe.vida_actual_IO());
					System.out.println("Jefe:" + temp_jefe.vida_actual_IO());
				}
				else {
					escritor.println("Enemigo:" + temp_enemigo.vida_actual_IO());
					System.out.println("Enemigo " + (enemigos_derrotados + 1) + ":" + temp_enemigo.vida_actual_IO());
				}
				if(murio != "") { // ACA TAMBIEN DEBERIA GUARDAR EN EL ARCHIVO
					escritor.println("Murio " + murio);
					System.out.print("Murio " + murio + " ");
					if(murio == "Enemigo") {
						System.out.print((enemigos_derrotados));
					}
					murio = ""; // lo reseteo para que no mande el mensaje de nuevo
					
					System.out.println("\n");
				}
			}
		}
		escritor.println("finalSimulacion");
		escritor.println("Jugador:" + temp_jugador.vida_actual_IO() + " Aliado:" + temp_aliado.vida_actual_IO() + " Jefe:" + temp_jefe.vida_actual_IO() + " Enemigos vivos: " + (matrix.Mundo[3] - enemigos_derrotados ));
		System.out.println("Fin simulacion.");
		// aca deberia guardar en EL ARCHIVO LO ULTIMO
		matrix.reset_Mundo();
	}
	
	public static void main (String [ ] args) {
		
		portal_dimensional = new Nivel[100];
		cant_niveles = 0; // como aun no se lee el archivo partimos con 0 niveles creados
		// todas estas variables son para leer el archivo
		String []hola;
		int []datos_nivel;
		String []lectura_nivel;
		int contador_nivel;
		int cargados=0;
		Nivel nivelaux;
		Objeto objetoaux;
		String []niveles_cargadoss= new String [100];
	    File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		System.out.println("----------- Simulador de Niveles ---------------");
		try {
		  // Apertura del fichero y creacion de BufferedReader para poder
          // hacer una lectura comoda (disponer del metodo readLine()).
          archivo = new File("niveles.txt");
          fr = new FileReader (archivo);
          br = new BufferedReader(fr);

          // Lectura del fichero
          String linea;
          contador_nivel=0;
          datos_nivel= new int[20];
          lectura_nivel= new String[10];
          while((linea=br.readLine())!=null) {
        	  contador_nivel+=1;
	          if("#".equals(linea)) {
	        	  contador_nivel=0;
		          datos_nivel= new int[20];
		          lectura_nivel= new String[10];
	          }
	          if(contador_nivel==1) {
	        	  lectura_nivel[0]=linea;
	        	  niveles_cargadoss[cargados]=linea;
	        	  cargados+=1;
	          }
	          else if (contador_nivel==2) {
	        	  hola=linea.split(" ");
	        	  lectura_nivel[1]=hola[0];
	        	  for(int i=0; i < 7; i ++) {
	        		  datos_nivel[i]=Integer.parseInt(hola[i+1]);
	        	  }
	        	  lectura_nivel[2]=hola[8];
	        	  datos_nivel[7]=Integer.parseInt(hola[9]);
	          }
	          else if (contador_nivel==3) {
	        	  hola=linea.split(" ");
	        	  lectura_nivel[2]=hola[0];
	        	  for(int i=0; i < 4; i ++) {
	        		  datos_nivel[i+8]=Integer.parseInt(hola[i+1]);
	        	  }
	          }
	          else if (contador_nivel==4) {
	        	  hola=linea.split(" ");
	        	  lectura_nivel[3]=hola[1];
	        	  datos_nivel[12]=Integer.parseInt(hola[0]);
	        	  datos_nivel[13]=Integer.parseInt(hola[2]);
	        	  
	          }
	          else if(contador_nivel==5) {
	        	  hola=linea.split(" ");
	        	  lectura_nivel[4]=hola[0];
	        	  datos_nivel[14]=Integer.parseInt(hola[1]);
	        	  
	          }
	          else if(contador_nivel==6) {
	        	  hola=linea.split(" ");
	        	  for(int i=0; i < 4; i ++) {
	        		  datos_nivel[i+15]=Integer.parseInt(hola[i]);
	        		  
	        	  }
	        	  nivelaux= new Nivel(lectura_nivel[0],cargados);
	        	  objetoaux= new Objeto(datos_nivel[7],lectura_nivel[3]);
	        	  nivelaux.crear_jugador(lectura_nivel[1], datos_nivel[0], datos_nivel[1], datos_nivel[2], datos_nivel[4], datos_nivel[6], datos_nivel[3], datos_nivel[5], objetoaux);
	        	  nivelaux.crear_villano(datos_nivel[8], datos_nivel[9], datos_nivel[10], datos_nivel[11], lectura_nivel[2]);
	        	  objetoaux= new Objeto(datos_nivel[13],lectura_nivel[4]);
	        	  nivelaux.crear_aliado(datos_nivel[12], objetoaux);
	        	  objetoaux= new Objeto(datos_nivel[14],lectura_nivel[5]);
	        	  nivelaux.crear_objeto_nivel(objetoaux);
	        	  nivelaux.crear_enemigo(datos_nivel[16], datos_nivel[17], datos_nivel[18], datos_nivel[15]);
	        	  cant_niveles += 1;
	        	  portal_dimensional[cant_niveles-1] = nivelaux;
	          }
             
          }
	      }
	       catch(Exception e){
	          e.printStackTrace();
	       }finally{
	          // En el finally cerramos el fichero, para asegurarnos
	          // que se cierra tanto si todo va bien como si salta 
	          // una excepcion.
	          try{                    
	             if( null != fr ){   
	                fr.close();     
	             }                  
	          }catch (Exception e2){ 
	             e2.printStackTrace();
	          }
	    }
	    System.out.println("Niveles Cargados: " );
		for(int i=0; i<cargados;i++) {
			System.out.println(niveles_cargadoss[i]);
		}
		System.out.println(" " );
		try {
			FP = new FileWriter("niveles.txt",true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error a la hora de abrir el archivo \"niveles.txt\"");
			e.printStackTrace();
		}
		try {
			Re = new FileWriter("registro_simulaciones.txt",true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error a la hora de abrir el archivo \"registro_simulaciones.txt\"");
			e.printStackTrace();
		}
		writer = new PrintWriter(FP);
		escritor = new PrintWriter(Re);
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
					writer.println("#");

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
					guardar_Nivel(cuarta_dimension);
					System.out.println("Nivel Creado");
					
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
						System.out.print("\nElegir: ");
						choice_lvl = terminal.nextInt();
						while(choice_lvl > cant_niveles || choice_lvl < 1) { // revisa que sea una opcion valida
							System.out.println("Opcion Invalida!,");
							System.out.print("Por favor ingrese otra opcion: ");
							choice_lvl = terminal.nextInt();
						}
						simulacion(portal_dimensional[choice_lvl-1]);// aca se llama a la funcion simulacion
					}
				}
				else if(opcion == 3) {
					if(cant_niveles == 0) {
						System.out.println("Aun no crean Niveles!");
					}
					else {
						int choice_lvl;
						for(int i = 0; i < cant_niveles ; i++) {
							System.out.print(portal_dimensional[i].StringName() + " "); ;
						}
						System.out.print("\nElegir: ");
						choice_lvl = terminal.nextInt();
						while(choice_lvl > cant_niveles || choice_lvl < 1) { // revisa que sea una opcion valida
							System.out.println("Opcion Invalida!,");
							System.out.print("Por favor ingrese otra opcion: ");
							choice_lvl = terminal.nextInt();
						}
						System.out.println(portal_dimensional[choice_lvl-1].StringAmigable());// aca se llama a la funcion simulacion

					}
				}
			}
		try {
			Re.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el archivo \"registro_simulacion.txt\"");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FP.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el archivo \"niveles.txt\"");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Adios!");
	}
}