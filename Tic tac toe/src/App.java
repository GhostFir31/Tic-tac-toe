import java.util.Scanner;

public class App {
  
  private Scanner leer = new Scanner(System.in);

  private GatoView tablero;//juego

  private GatoControl juego;//turno /jugador
  
  private GatoControl turno;

  private int posicion;

  private int opcion;

  public static void main(String[] args) throws Exception {
   
    App App =new App();

     App.iniciarJuego();
   
  }

  public void iniciarJuego(){
   
    tablero = new GatoView();
    turno=new GatoControl();
    
do{
 System.out.println("1.Jugar");
 System.out.println("2.Reset");
   
   opcion=leer.nextInt();

   switch(opcion){

    case 1:System.out.println("Introduzca La posicion que se desea del 1 al 9");
     
     posicion=leer.nextInt();

     if(turno.getTurno()==true){

     tablero.dibujarFicha(posicion,turno);
     
     cambiarJugador(turno);
    }
    else{

     tablero.dibujarFicha(posicion,turno);
     
       cambiarJugador(turno);
     }
     turno.mostrar();
     break;
     case 2: tablero.reset();
             break;
    }
    }while(posicion!=10);

  }

  public void cambiarJugador(GatoControl jugador){

    if(turno.getTurno()==true){

        turno.setTurno(false);

       }
       else{
        turno.setTurno(true);
        }
}

}
