import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class GatoControl {
    
 private   int circulo;

 private   int x;

 private boolean turno;
 private boolean ganador;

 ArrayList <Boolean> circulos;

public GatoControl(){

    turno=true;
    ganador=false;
    circulos=new ArrayList<>(Collections.nCopies(9, false));

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

public boolean colocarFicha(int posicion){

if(circulos.get(posicion)==true){

    return true;

}else{

 return false;

}
//verifica si esta libre el espacio
}

public void mostrar(){
//ojo que se puede solo imprimir lso primeros 3 valores 3 veces
for(int j=0;j<3;j++){
for(int i=0;i<3;i++){

System.out.print("  "+circulos.get(i)+"  ");

}

System.out.println(" ");
}
}
public void reset(GatoControl jugador){

Scanner leer=new Scanner(System.in);

int opcion;
do{
System.out.println("1)Borrar todas las fichas.");
System.out.println("2)Conceder el turno al primer jugador.");
System.out.println("3)Indicar que si hay ganador");
System.out.println("4)Salir");

opcion=leer.nextInt();

switch(opcion){

case 1: GatoView juego=new GatoView();
              juego.reset();
         break;
case 2: System.out.println("Turno concedido");
         jugador.setTurno(true);
         break;
case 3: System.out.println("ganador:" + jugador.hayGanador(ganador) );
         break;

case 4: System.out.println("Salir");
        break;

        default:System.out.println("El valor introducido no es valido");
}
}while(opcion!=4);

}
    
}
