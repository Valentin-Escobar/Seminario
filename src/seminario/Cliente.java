package seminario;

public class Cliente {
    private int DNI;
    private String NombreApellido;
    private int Telefono;
    
    //Constructor vacío
    public Cliente() {
    	
    }
    
    //Constructor con parámetros
    public Cliente (int DNI, String NombreApellido, int Telefono) {
    	this.DNI = DNI;
    	this.NombreApellido = NombreApellido;
    	this.Telefono = Telefono;
  
    }
    
    //Getters y setters
    public int getDNI() {
    	return DNI;
    }
    
    public void setDNI(int DNI) {
    	this.DNI = DNI;
    }
    
    public String getNombreApellido() {
    	return NombreApellido;
    }
    
    public void setNombreApellido(String NombreApellido) {
    	this.NombreApellido = NombreApellido;
    }
    
    public int getTelefono() {
    	return Telefono;
    }
    
    public void setTelefono(int Telefono) {
    	this.Telefono = Telefono;
    }
}