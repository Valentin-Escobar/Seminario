package seminario;

import java.util.List;

public class TurnoController {
   private TurnoDAO turnoDAO;

   public TurnoController(TurnoDAO turnoDAO) {
      this.turnoDAO = turnoDAO;
   }

   public void addTurno(Turno turno) {
      this.turnoDAO.addTurno(turno);
   }

   public void updateTurno(Turno turno) {
      this.turnoDAO.updateTurno(turno);
   }

   public void deleteCliente(int Dia) {
      this.turnoDAO.deleteTurno(Dia);
   }

   public Turno getTurnoByDia(int Dia) {
      return this.turnoDAO.getTurnoByDia(Dia);
   }

   public List<Turno> getAllTurnos() {
      return this.turnoDAO.getAllTurnos();
   }
}