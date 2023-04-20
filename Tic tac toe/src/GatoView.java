

public class GatoView {

  static Canvas pantalla;

  private Square cuadro;

  private int ESPACIO = 122;

  private int xPosition = 0;

  private int yPosition = 0;

  private Circle circulo;

  public GatoView() {
    
    dibujarTablero();

  }

  public void dibujarTablero() {
    Canvas.getCanvas();

    for (int i = 0; i < 3; i++) {
      xPosition = 0;

      for (int y = 0; y < 3; y++) {
        cuadro = new Square(120, "white", xPosition, yPosition);

        xPosition += ESPACIO;
      }

      yPosition += ESPACIO;
    }
  }

  public void dibujarFicha(int posicion,GatoControl jugador) {

    //jugador.getTurno();

    switch (posicion) {
      case 1:
        xPosition = 3;
        yPosition = 0;

        circulo = new Circle(115, xPosition, yPosition,jugador);

        break;
      case 2:
        xPosition = 124;
        yPosition = 0;

        circulo = new Circle(115,xPosition, yPosition,jugador);

        break;
      case 3:
        xPosition = 246;
        yPosition = 0;

        circulo = new Circle(115,xPosition, yPosition,jugador);

        break;
      case 4:
        xPosition = 3;
        yPosition = 125;

        circulo = new Circle(115,xPosition, yPosition,jugador);

        break;
      case 5:
        xPosition = 124;
        yPosition = 125;

        circulo = new Circle(115,xPosition, yPosition,jugador);

        break;
      case 6:
        xPosition = 246;
        yPosition = 125;

        circulo = new Circle(115,xPosition, yPosition,jugador);

        break;
      case 7:
        xPosition = 3;
        yPosition = 245;

        circulo = new Circle(115,xPosition, yPosition,jugador);

        break;
      case 8:
        xPosition = 124;
        yPosition = 245;

        circulo = new Circle(115,xPosition, yPosition,jugador);

        break;
      case 9:
        xPosition = 246;
        yPosition = 245;

        circulo = new Circle(115,xPosition, yPosition,jugador);

        break;

      default:System.out.println("Numero no valido ");

    }
  }

  public void reset() {

   new GatoView();

  }


}
