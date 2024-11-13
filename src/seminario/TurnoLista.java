package seminario;

import java.util.ArrayList;


public class TurnoLista {
	private ArrayList<Cliente> clientes;
	
	//Constructor vacío
	public TurnoLista() {
		this.clientes = new ArrayList<>();
	}
	
	//Constructor con parámetros
	public TurnoLista (ArrayList<Cliente> clientes) {
            this.clientes = clientes;
        }
	
	
	//Getters y setters
	public ArrayList<Cliente> getclientes() {
        return clientes;
    }

    public void setAlumnos(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
   
    
 // Método para asignar un turno a un cliente
    public void AsignarTurno(Cliente cliente) {
    	if (clientes.size() < 12) {
    		clientes.add(cliente);
    		System.out.println("cliente asignado al turno seleccionado correctamente ");
    	} else {
    		System.out.println ("Número máximo de clientes en un mismo turno del día");
    	}
    }
}
