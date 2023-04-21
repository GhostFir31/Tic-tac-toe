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
    boolean espacioValido = true;
    do {
      System.out.println("1.Jugar");
      System.out.println("2.Reset");
      System.out.println("3.Salir");
      opcion = leer.nextInt();

      switch (opcion) {
        case 1:
          do {
            System.out.println("Introduzca La posicion " + juego.getFicha() + " que se desea del 1 al 9");

            posicion = leer.nextInt();

            if (posicion > 0 && posicion <= 9) {

              espacioValido = juego.colocarFicha(posicion);

              if (espacioValido) {
                tablero.dibujarFicha(posicion, juego);

                juego.verificaFichaGanadora();

                juego.cambiarJugador();
              }

            } else {

              System.out.println("Solo se puede con numeros del 1 al 9");
              espacioValido = false;
            }

          } while (!juego.hayGanador() && !juego.getEmpate());

          juego.hayMostrarGanador();

          break;
        case 2:

          juego.reset(juego, tablero);

          break;
        case 3:

          System.out.println("Saliendo");

          break;

        default:
          System.out.println("Error ponga una opcion en el menu");
      }

    } while (opcion != 3);

  }

}
