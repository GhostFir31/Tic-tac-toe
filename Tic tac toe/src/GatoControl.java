
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GatoControl {
    
 private boolean turno;
 private boolean ganador;
 private boolean empate;
 private char ficha;

 ArrayList <Character> circulos;

public GatoControl(){

    turno=true;
    ganador=false;
    empate=false;
    ficha='X';
    circulos=inicializaTablero();

}

public ArrayList<Character> inicializaTablero(){

    circulos=new ArrayList<>(Collections.nCopies(9, null));

return circulos;

}

public void cambiarJugador() {
    if (getTurno() == true) {
      setFicha('O');
      setTurno(false);

    } else {
      setFicha('X');
      setTurno(true);
    }
  }
public void setTurno(boolean turno){

this.turno=turno;

}

public boolean getTurno(){

    return turno;

}

public void setGanador(boolean ganador){

this.ganador=ganador;
    
}

public boolean hayGanador(){

    return ganador;
        
    }

public char getFicha(){

return ficha;

}

public void setFicha(char ficha){

    this.ficha=ficha;
    
    }

public void setEmpate(boolean empate){

this.empate=empate;

}

public boolean getEmpate(){

    return empate;
    
    }

public void hayMostrarGanador(){
 String color;

 if(getEmpate()==true){

   System.out.println("! EMPATE !");

 }else if(hayGanador()==true){

      if(getFicha()=='O'){

            color ="rojo";

            System.out.println("Jugador "+color+" gano el juego.");

      }else if(getFicha()=='X'){
 
        color ="negro";

        System.out.println("Jugador "+color+" gano el juego.");

      }

 }
 
}
    
public boolean colocarFicha(int posicion){

//colobora si esta vacio el espacio ocupado    
if(circulos.get(posicion-1)==null){
 
    if(getTurno()==true){

         colocar(getFicha(),posicion);
          
        }else
        {

            colocar(getFicha(),posicion);

         circulos.set(posicion-1,getFicha());
        
        }
   return true;
}else{
 System.out.println("Espacio no valido puesto que un jugador ya tomo ese lugar");
 return false;
}

}

public boolean colocar(char ficha,int posicion){
    //ojo con los turnos 
    if(getTurno()==true){      

        circulos.set(posicion-1,ficha);

        return true;

        }else
        {

         circulos.set(posicion-1,ficha);

         return false;

        }
}

public void verificaFichaGanadora(){
   
    if(circulos.get(0) != null && circulos.get(1) != null && circulos.get(2) != null && circulos.get(0)==circulos.get(1) && circulos.get(0)==circulos.get(2)){
       
        setGanador(true);

    } else if (circulos.get(3) != null && circulos.get(4) != null && circulos.get(5) != null && circulos.get(3)==circulos.get(4) && circulos.get(3)==circulos.get(5)){
       
        setGanador(true);

    } else if (circulos.get(6) != null && circulos.get(7) != null && circulos.get(8) != null && circulos.get(6)==circulos.get(7) && circulos.get(6)==circulos.get(8)){
       
        setGanador(true);

    } else if (circulos.get(0) != null && circulos.get(3) != null && circulos.get(6) != null && circulos.get(0)==circulos.get(3) && circulos.get(0)==circulos.get(6)){
        
        setGanador(true);

    } else if (circulos.get(1) != null && circulos.get(4) != null && circulos.get(7) != null && circulos.get(1)==circulos.get(4) && circulos.get(1)==circulos.get(7)){
      
        setGanador(true);

    } else if (circulos.get(2) != null && circulos.get(5) != null && circulos.get(8) != null && circulos.get(2)==circulos.get(5) && circulos.get(2)==circulos.get(8)){
        
        setGanador(true);

    } else if (circulos.get(0) != null && circulos.get(4) != null && circulos.get(8) != null && circulos.get(0)==circulos.get(4) && circulos.get(0)==circulos.get(8)){
       
        setGanador(true);

    } else if (circulos.get(2) != null && circulos.get(4) != null && circulos.get(6) != null && circulos.get(2)==circulos.get(4) && circulos.get(2)==circulos.get(6)){
       
        setGanador(true);

    } else if (!circulos.contains(null)){
       
        setEmpate(true);

    }
    else {
       
        setGanador(false);

    }
    
} 

public void mostrar(){
//ojo que se puede solo imprimir los primeros 3 valores 3 veces

System.out.print("  "+circulos.get(0)+"  ");
System.out.print("  "+circulos.get(1)+"  ");
System.out.print("  "+circulos.get(2)+"  ");

System.out.println(" ");

System.out.print("  "+circulos.get(3)+"  ");
System.out.print("  "+circulos.get(4)+"  ");
System.out.print("  "+circulos.get(5)+"  ");

System.out.println(" ");

System.out.print("  "+circulos.get(6)+"  ");
System.out.print("  "+circulos.get(7)+"  ");
System.out.print("  "+circulos.get(8)+"  ");

System.out.println(" ");

}

public void reset(GatoControl juego, GatoView tablero){

Scanner leer=new Scanner(System.in);

int eleccion;
do{
System.out.println("1)Borrar todas las fichas.");
System.out.println("2)Conceder el turno al primer jugador.");
System.out.println("3)Indicar que si hay ganador");
System.out.println("4)Salir");

eleccion=leer.nextInt();


switch(eleccion){

case 1:       inicializaTablero();
              setTurno(true);
              tablero.reset();
         break;
case 2: System.out.println("Turno concedido");
         setTurno(true);
         break;
case 3: System.out.println("ganador:" + hayGanador());
         break;

case 4: System.out.println("Salir");
        break;

        default:System.out.println("El valor introducido no es valido");
}
}while(eleccion!=4);

}
    
}
