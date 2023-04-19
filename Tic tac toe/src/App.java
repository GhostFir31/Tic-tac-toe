import java.util.Scanner;

public class App {

  private Scanner leer = new Scanner(System.in);

  private GatoView tablero; // juego

  private GatoControl juego; // turno /jugador

 // private GatoControl turno;

  private int posicion;

  private int opcion;

  public static void main(String[] args) throws Exception {
    App App = new App();

    App.iniciarJuego();
  }

  public void iniciarJuego() {
    
    juego = new GatoControl();
    tablero = new GatoView();

    do {
      System.out.println("1.Jugar");
      System.out.println("2.Reset");

      opcion = leer.nextInt();

      switch (opcion) {
        case 1:
          System.out.println("Introduzca La posicion que se desea del 1 al 9");

          posicion = leer.nextInt();

          if(posicion>0 && posicion<=9){

            juego.colocarFicha(posicion);

            tablero.dibujarFicha(posicion, juego);
            
            juego.verificaFichaGanadora();

            juego.hayMostrarGanador();

            juego.cambiarJugador();

          juego.mostrar();

        }else{

          System.out.println("Solo se puede con numeros del 1 al 9");

         }
          break;
        case 2:

          juego.reset(juego,tablero);

          break;
      }
    } while (juego.hayGanador()==true);
  }


}
