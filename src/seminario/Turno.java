package seminario;

public class Turno {
    private int Dia;
    private int Mes;
    private int Hora;
    
    //Constructor vacío
    public Turno() {
    	
    }
        
        //Constructor con parámetros
	public Turno (int Dia, int Mes, int Hora) {
		this.Dia = Dia;
                this.Mes = Mes;
		this.Hora = Hora;
	}
		

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }
}
	
   