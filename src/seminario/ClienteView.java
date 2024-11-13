package seminario;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class ClienteView {
   public void printClienteDetails(Cliente cliente) {
      System.out.println("DNI: " + cliente.getDNI());
      System.out.println("Nombre y apellido: " + cliente.getNombreApellido());
      System.out.println("Telefono: " + cliente.getTelefono());
   }

   public void printClientesDetails(List<Cliente> clientes) {
	   Iterator var2 = clientes.iterator();

      while(var2.hasNext()) {
         Cliente cliente = (Cliente)var2.next();
         PrintStream var10000 = System.out;
         int var10001 = cliente.getDNI();
         var10000.println(var10001 + ": " + cliente.getNombreApellido() + " " + cliente.getTelefono());
      }

   }
}