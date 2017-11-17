import java.util.Scanner;
public class Juego{
	
	
	Nivel cuarta_dimension;
	static int  opcion=-1;
	static Scanner terminal;
	
	public static void crear_jugador() {
		String nombreaux;
		
	}
	public static void main (String [ ] args) {
		
	System.out.println("-----------Simulador de Niveles---------------");
	terminal = new Scanner (System.in);
		while(opcion!=4) {
			
			System.out.println("1. Crear Niveles");
			System.out.println("2. Simular cambios en Nivel");
			System.out.println("3. Consultar información de Nivel");
			System.out.println("4. Salir");
			
			opcion=terminal.nextInt();
			while(opcion > 4 || opcion < 1) {
				System.out.println("Ingrese otra opcion: ");
				opcion=terminal.nextInt();
			}
			if(opcion == 1) {
				crear_jugador();
			}

			System.out.println(opcion);
		}
	}
}