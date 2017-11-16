abstract class Personaje{
  protected int vida_actual;
  protected int vida_base;
  
  // el constructor creo q no va aca...(nbo estoy seguro)
  public Personaje(int vida_inicial){
    vida_actual=vida_inicial;
    vida_base=vida_inicial;
  }
  
  /** Entrega la vida actual de un NPC, si este tiene defenesa base se la suma */
  abstract int vida_actual(); 
}

