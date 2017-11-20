import java.io.PrintWriter;
import java.lang.Math;
public class Jefe extends Personaje_Ataca implements Ataque, AtaqueEspecial {
	String Nombre;
	int ataque_especial; //es el ataque especial que puede poseer
	
	/******** Metodo: Jefe ********************
Descripcion: constructor del jege
Parametros:
vida entero
ataque entero
defensa entero
ataque_Especia entero
nombre string
Retorno: el jefe
************************************************/
	public Jefe(int vida_inicial,int ataque_inicial, int defensa_inicial, int ataque_2,String Name){
		super(vida_inicial,ataque_inicial,defensa_inicial,"malo");
		Nombre = Name;
		ataque_especial=ataque_2;
	}
/******** Metodo: Jefe ********************
Descripcion: genera el jefe con cambios
Parametros:
jefe con cambios
Retorno: retorna el jefe con cambios
************************************************/
	public Jefe(Jefe aux) {
		super(aux.vida_actual,aux.ataque_base,aux.defensa_base,"malo");
		Nombre = aux.Nombre;
		ataque_especial = aux.ataque_especial;
	}
/******** Metodo: vida_actual_enAtaque ********************
Descripcion: retorna la vda en ataque
Retorno: retorna la vida mas la defensa
************************************************/
	public int vida_actual_enAtaque() {
		return vida_actual + defensa_base;
	}
/******** Metodo: vida_actual_IO ********************
Descripcion: retonala vida en modo pasivo

Retorno: retorna la vida actual
************************************************/
	public int vida_actual_IO() {
		return vida_actual;
	}
/******** Metodo: cambio_vida ********************
Descripcion: aplica el danno recibido a la vida del jefe
Parametros:
ataque entero

Retorno: la vida con el danno aplicado
************************************************/
	public int cambio_vida(int ataque) {
		int cambio_vida;
		cambio_vida = vida_actual_enAtaque() - ataque;
		
		if(cambio_vida<0) {
			cambio_vida=0;
		}
		if(cambio_vida > vida_actual) {
			return vida_actual;
		}
		vida_actual=cambio_vida;
		return cambio_vida;
	}
/******** Metodo: Atacar********************
Descripcion: ataca
Retorno: retorna el ataque base
************************************************/
	public int Atacar() {
		return ataque_base;
	}
/******** Metodo:atacar_especial ********************
Descripcion: ataca con el ataque especial
Retorno: lel ataque especial
************************************************/
	public int Atacar_Especial() {
		return ataque_base+ataque_especial;
	}
	public int Probabilidad_Especial(PrintWriter escritor) {
		int random = (int) Math.random()*(3);
		
		if (random == 0) {
			escritor.print("Especial");
			System.out.print("Especial ");
			return Atacar_Especial();
		}
		else {
			return Atacar();
		}
	}
/******** Metodo: toString********************
Descripcion: retorna los datos del jefe
Retorno: los datos de jefe
************************************************/
	public String toString() {
		 return Nombre +" "+ vida_actual +" "+ ataque_base +" "+ defensa_base +" "+ataque_especial;
	}
}
