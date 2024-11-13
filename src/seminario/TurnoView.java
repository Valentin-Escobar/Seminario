package seminario;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class TurnoView {
   public void printTurnoDetails(Turno turno) {
      System.out.println("Dia: " + turno.getDia());
      System.out.println("Mes: " + turno.getMes());
      System.out.println("Hora: " + turno.getHora());
   }

   public void printTurnosDetails(List<Turno> turnos) {
	   Iterator var2 = turnos.iterator();

      while(var2.hasNext()) {
         Turno turno = (Turno)var2.next();
         PrintStream var10000 = System.out;
         int var10001 = turno.getDia();
         var10000.println(var10001 + ": " + turno.getMes() + " " + turno.getHora());
      }

   }
}
