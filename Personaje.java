abstract class Personaje{
  protected int vida_actual;
  public String Tipo;
  // el constructor creo q no va aca...(nbo estoy seguro)
  public Personaje(int vida_inicial,String ntipo){
    vida_actual=vida_inicial;
    Tipo = ntipo;
  }
  
  /** Entrega la vida actual de un NPC, si este tiene defenesa base, objetos, etc.
   *  se la suma. */
  abstract int vida_actual_enAtaque();
  /** Esta es para mostrar en Pantalla, solo considera la vida_actual. */
  abstract int vida_actual_IO();
  /** Afecta la vida del NPC en cuestion, retorna la vida resultante, la implementacion
   * dependera si nuestro NPC tiene defensa, objetos, etc.*/
  abstract int cambio_vida(int ataque);
}

