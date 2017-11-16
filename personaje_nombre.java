public class personaje_nombre extends personaje_ataca
{
  protected String nombre;
 
  public personaje_nombre(int vida_inicial, int ataque_inicial,String nombre)
  {
    super(vida_inicial,ataque_inicial);
  }
  public String nombre_personaje(){
    return nombre;
  }
  
  
}

