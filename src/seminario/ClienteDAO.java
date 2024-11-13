package seminario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
   public void addCliente(Cliente cliente) {
      String sql = "INSERT INTO clientes (DNI, NombreApellido, Telefono) VALUES (?, ?, ?)";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               stmt.setInt(1, cliente.getDNI());
               stmt.setString(2, cliente.getNombreApellido());
               stmt.setInt(3, cliente.getTelefono());
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

   public List<Cliente> getAllClientes() {
      List<Cliente> clientes = new ArrayList();
      String sql = "SELECT DNI, NombreApellido, Telefono FROM clientes";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               ResultSet rs = stmt.executeQuery();

               try {
                  while(rs.next()) {
                     Cliente cliente = new Cliente();
                     cliente.setDNI(rs.getInt("DNI"));
                     cliente.setNombreApellido(rs.getString("NombreApellido"));
                     cliente.setTelefono(rs.getInt("Telefono"));
                     clientes.add(cliente);
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

      return clientes;
   }

   public void updateCliente(Cliente cliente) {
      String sql = "UPDATE clientes set NombreApellido = ?, Telefono = ? where DNI = ?";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               stmt.setString(1, cliente.getNombreApellido());
               stmt.setInt(2, cliente.getTelefono());
               stmt.setInt(3, cliente.getDNI());
               
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

   public void deleteCliente(int DNI) {
      String sql = "DELETE FROM clientes WHERE DNI = ?";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               stmt.setInt(1, DNI);
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

   public Cliente getClienteByDNI(int DNI) {
      Cliente cliente = null;
      String sql = "SELECT DNI, NombreApellido, Telefono FROM Clientes WHERE DNI = ?";

      try {
         Connection conn = Database.conectar();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               stmt.setInt(1, DNI);
               ResultSet rs = stmt.executeQuery();

               try {
                  if (rs.next()) {
                     cliente = new Cliente();
                     cliente.setDNI(rs.getInt("DNI"));
                     cliente.setNombreApellido(rs.getString("nombreApellido"));
                     cliente.setTelefono(rs.getInt("Telefono"));
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

      return cliente;
   }
}