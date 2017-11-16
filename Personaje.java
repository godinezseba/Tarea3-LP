abstract class Personaje{
	
  protected int vida_actual;
  protected int vida_base;
  
  // el constructor creo q no va aca...(nbo estoy seguro)
  public Personaje(int vida_inicial){
    vida_actual=vida_inicial;
    vida_base=vida_inicial;
  }
  
  /** Entrega la vida actual de un NPC, si este tiene defenesa base, objetos, etc.
   *  se la suma. */
  abstract int vida_actual_enAtaque();
  /** Esta es para mostrar en Pantalla, solo considera la vida_actual. */
  abstract int vida_actual_IO();
  /** Afecta la vida del NPC en cuestion, retorna la vida resultante, la implementacion
   * dependera si nuestro NPC tiene defensa, objetos, etc.*/
  abstract int cambio_vida();
}

