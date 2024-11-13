package seminario;

import java.util.List;

public class ClienteController {
   private ClienteDAO clienteDAO;

   public ClienteController(ClienteDAO clienteDAO) {
      this.clienteDAO = clienteDAO;
   }

   public void addCliente(Cliente cliente) {
      this.clienteDAO.addCliente(cliente);
   }

   public void updateCliente(Cliente cliente) {
      this.clienteDAO.updateCliente(cliente);
   }

   public void deleteCliente(int dni) {
      this.clienteDAO.deleteCliente(dni);
   }

   public Cliente getClienteByDNI(int dni) {
      return this.clienteDAO.getClienteByDNI(dni);
   }

   public List<Cliente> getAllClientes() {
      return this.clienteDAO.getAllClientes();
   }
}