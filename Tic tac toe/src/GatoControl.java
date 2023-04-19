
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GatoControl {
    
 private boolean turno;
 private boolean ganador;
 private char ficha;

 ArrayList <Character> circulos;

public GatoControl(){

    turno=true;
    ganador=false;
    ficha='n';
    circulos=inicializaTablero();

}

public ArrayList<Character> inicializaTablero(){

    circulos=new ArrayList<>(Collections.nCopies(9, null));

return circulos;

}

public void cambiarJugador() {
    if (getTurno() == true) {
      setTurno(false);
    } else {
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

public boolean hayGanador(boolean ganador){

    return ganador;
        
    }

public char getFicha(){

return ficha;

}

public void hayMostrarGanador(){
 String color;
 if(hayGanador(ganador)==false){

   System.out.println("No hay Ganador");

 }else{
      if(getFicha()=='X'){

            color ="Rojo";
      }else{
 
        color ="Negro";

      }
    System.out.println(" Jugador "+color+" gano el juego");

 }
 
}
    
public boolean colocarFicha(int posicion){
char ficha;
//colobora si esta vacio el espacio ocupado    
if(circulos.get(posicion-1)==null){
 
    if(getTurno()==true){
        ficha='X';
        
         colocar(ficha,posicion);
          
        }else
        {
            ficha='O';
            colocar(ficha,posicion);
         circulos.set(posicion-1,ficha);
        
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

public boolean verificaFichaGanadora(){

    if(circulos.get(0)==circulos.get(1) && circulos.get(0)==circulos.get(2)){
       
        ganador=true;
    } else if (circulos.get(3)==circulos.get(4) && circulos.get(3)==circulos.get(5)){
        
        ganador=true;
    } else if (circulos.get(6)==circulos.get(7) && circulos.get(6)==circulos.get(8)){
      
        ganador=true;
    } else if (circulos.get(0)==circulos.get(3) && circulos.get(0)==circulos.get(6)){
       
        ganador=true;
    } else if (circulos.get(1)==circulos.get(4) && circulos.get(1)==circulos.get(7)){
        
        ganador=true;
    } else if (circulos.get(2)==circulos.get(5) && circulos.get(2)==circulos.get(8)){
        
        ganador=true;
    } else if (circulos.get(0)==circulos.get(4) && circulos.get(0)==circulos.get(8)){
        
        ganador=true;
    } else if (circulos.get(2)==circulos.get(4) && circulos.get(2)==circulos.get(6)){
        
        ganador=true;
    } else {
      
        ganador=false;
    }

    return ganador;
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

public void reset(){

Scanner leer=new Scanner(System.in);

int opcion;
do{
System.out.println("1)Borrar todas las fichas.");
System.out.println("2)Conceder el turno al primer jugador.");
System.out.println("3)Indicar que si hay ganador");
System.out.println("4)Salir");

opcion=leer.nextInt();

switch(opcion){

case 1: GatoView tablero=new GatoView();
        GatoControl juego=new GatoControl(); 
              juego.reset();
              tablero.reset();
         break;
case 2: System.out.println("Turno concedido");
         setTurno(true);
         break;
case 3: System.out.println("ganador:" + hayGanador(ganador) );
         break;

case 4: System.out.println("Salir");
        break;

        default:System.out.println("El valor introducido no es valido");
}
}while(opcion!=4);

}
    
}
