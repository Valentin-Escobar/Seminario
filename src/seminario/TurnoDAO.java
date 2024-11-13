package seminario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {
   public void addTurno(Turno turno) {
      String sql = "INSERT INTO turnos (Dia, Mes, Hora) VALUES (?, ?, ?)";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               stmt.setInt(1, turno.getDia());
               stmt.setInt(2, turno.getMes());
               stmt.setInt(3, turno.getHora());
               stmt.executeUpdate();
            } catch (Throwable var9) {
               if (stmt != null) {
                  try {
                     stmt.close();
                  } catch (Throwable var8) {
                     var9.addSuppressed(var8);
                  }
               }

               throw var9;
            }

            if (stmt != null) {
               stmt.close();
            }
         } catch (Throwable var10) {
            if (conn != null) {
               try {
                  conn.close();
               } catch (Throwable var7) {
                  var10.addSuppressed(var7);
               }
            }

            throw var10;
         }

         if (conn != null) {
            conn.close();
         }
      } catch (SQLException var11) {
         var11.printStackTrace();
      }

   }

   public List<Turno> getAllTurnos() {
      List<Turno> turnos = new ArrayList();
      String sql = "SELECT Dia, Mes, Hora FROM turnos";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               ResultSet rs = stmt.executeQuery();

               try {
                  while(rs.next()) {
                     Turno turno = new Turno();
                     turno.setDia(rs.getInt("Dia"));
                     turno.setMes(rs.getInt("Mes"));
                     turno.setHora(rs.getInt("Hora"));
                     turnos.add(turno);
                  }
               } catch (Throwable var11) {
                  if (rs != null) {
                     try {
                        rs.close();
                     } catch (Throwable var10) {
                        var11.addSuppressed(var10);
                     }
                  }

                  throw var11;
               }

               if (rs != null) {
                  rs.close();
               }
            } catch (Throwable var12) {
               if (stmt != null) {
                  try {
                     stmt.close();
                  } catch (Throwable var9) {
                     var12.addSuppressed(var9);
                  }
               }

               throw var12;
            }

            if (stmt != null) {
               stmt.close();
            }
         } catch (Throwable var13) {
            if (conn != null) {
               try {
                  conn.close();
               } catch (Throwable var8) {
                  var13.addSuppressed(var8);
               }
            }

            throw var13;
         }

         if (conn != null) {
            conn.close();
         }
      } catch (SQLException var14) {
         var14.printStackTrace();
      }

      return turnos;
   }

   public void updateTurno(Turno turno) {
      String sql = "UPDATE turnos set Mes = ?, Hora = ? where Dia = ?";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               stmt.setInt(1, turno.getMes());
               stmt.setInt(2, turno.getHora());
               stmt.setInt(3, turno.getDia());
               
               stmt.executeUpdate();
            } catch (Throwable var9) {
               if (stmt != null) {
                  try {
                     stmt.close();
                  } catch (Throwable var8) {
                     var9.addSuppressed(var8);
                  }
               }

               throw var9;
            }

            if (stmt != null) {
               stmt.close();
            }
         } catch (Throwable var10) {
            if (conn != null) {
               try {
                  conn.close();
               } catch (Throwable var7) {
                  var10.addSuppressed(var7);
               }
            }

            throw var10;
         }

         if (conn != null) {
            conn.close();
         }
      } catch (SQLException var11) {
         var11.printStackTrace();
      }

   }

   public void deleteTurno(int Dia) {
      String sql = "DELETE FROM turnos WHERE Dia = ?";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               stmt.setInt(1, Dia);
               stmt.executeUpdate();
            } catch (Throwable var9) {
               if (stmt != null) {
                  try {
                     stmt.close();
                  } catch (Throwable var8) {
                     var9.addSuppressed(var8);
                  }
               }

               throw var9;
            }

            if (stmt != null) {
               stmt.close();
            }
         } catch (Throwable var10) {
            if (conn != null) {
               try {
                  conn.close();
               } catch (Throwable var7) {
                  var10.addSuppressed(var7);
               }
            }

            throw var10;
         }

         if (conn != null) {
            conn.close();
         }
      } catch (SQLException var11) {
         var11.printStackTrace();
      }

   }

   public Turno getTurnoByDia(int Dia) {
      Turno turno = null;
      String sql = "SELECT Dia, Mes, Hora FROM Turnos WHERE Dia = ?";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               stmt.setInt(1, Dia);
               ResultSet rs = stmt.executeQuery();

               try {
                  if (rs.next()) {
                     turno = new Turno();
                     turno.setDia(rs.getInt("Dia"));
                     turno.setMes(rs.getInt("Mes"));
                     turno.setHora(rs.getInt("Hora"));
                  }
               } catch (Throwable var12) {
                  if (rs != null) {
                     try {
                        rs.close();
                     } catch (Throwable var11) {
                        var12.addSuppressed(var11);
                     }
                  }

                  throw var12;
               }

               if (rs != null) {
                  rs.close();
               }
            } catch (Throwable var13) {
               if (stmt != null) {
                  try {
                     stmt.close();
                  } catch (Throwable var10) {
                     var13.addSuppressed(var10);
                  }
               }

               throw var13;
            }

            if (stmt != null) {
               stmt.close();
            }
         } catch (Throwable var14) {
            if (conn != null) {
               try {
                  conn.close();
               } catch (Throwable var9) {
                  var14.addSuppressed(var9);
               }
            }

            throw var14;
         }

         if (conn != null) {
            conn.close();
         }
      } catch (SQLException var15) {
         var15.printStackTrace();
      }

      return turno;
   }
}