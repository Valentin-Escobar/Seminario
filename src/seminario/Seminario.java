package seminario;

import java.util.Scanner;
import java.sql.*;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Seminario {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
                TurnoDAO turnoDAO = new TurnoDAO();
	        ClienteView clienteView = new ClienteView();
                TurnoView turnoView = new TurnoView();
		ClienteController clienteController = new ClienteController(clienteDAO);
                TurnoController turnoController = new TurnoController(turnoDAO);
                TurnoLista turnoLista = new TurnoLista();
		
                boolean continuar = false;
		while (!continuar) {
			System.out.println("/n Inicio");
			System.out.println("/1- Registrar cliente");
			System.out.println("/2- Editar cliente");
                        System.out.println("/3- Eliminar cliente");
                        System.out.println("/4- Consultar cliente");
                        System.out.println("/5- Listar clientes");
                        System.out.println("/6- Crear turno");
                        System.out.println("/7- Editar turno");
                        System.out.println("/8- Eliminar turno");
                        System.out.println("/9- Seleccionar turno");
                        System.out.println("/10- Listar turnos");
                        System.out.println("/11- Asignar turno al cliente");
                        System.out.println("/12- Cerrar");
			System.out.print("Ingrese la opción deseada: ");
			int opcion = scanner.nextInt();
			
			try {
				switch(opcion) {
				case 1: RegistrarCliente(scanner, clienteController);
                                        break;
				case 2: EditarCliente(scanner, clienteController);
                                        break;
                                case 3: EliminarCliente(scanner, clienteController);
                                        break;
                                case 4: ConsultarDatosCliente(scanner, clienteController, clienteView);
                                        break;
                                case 5: ListarTodosLosClientes(clienteController, clienteView);
                                        break;
                                case 6: CrearTurno(scanner, turnoController);
                                        break;
                                case 7: EditarTurno(scanner, turnoController);
                                        break;
                                case 8: EliminarTurno(scanner, turnoController);
                                        break;
                                case 9: SeleccionarTurno(scanner, turnoController, turnoView);
                                        break;
                                case 10: ListarTodosLosTurnos(turnoController, turnoView);
                                         break;
                                case 11: AsignarTurnoACliente(scanner, turnoLista, clienteController);
                                         break;
				case 12: {
					System.exit(0);
				}
				
				default: System.out.println("Opcion invalida");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Ingrese una opcion valida");
				scanner.next();
			}
			
		}
		
	}
	
	
	
    private static void RegistrarCliente(Scanner scanner, ClienteController clienteController) {
	  
	  try {
		  System.out.print("DNI del cliente: ");
		  int DNI = scanner.nextInt();
		  System.out.print("Nombre y apellido del cliente: ");
		  String NombreApellido = scanner.next();
		  System.out.print("Telefono del cliente: ");
		  int Telefono = scanner.nextInt();
		  
		  Cliente NuevoCliente = new Cliente(DNI, NombreApellido, Telefono);
		  
		  clienteController.addCliente(NuevoCliente);
		  System.out.println("Cliente registrado con éxito");
	  } catch (InputMismatchException e) {
	        System.out.println("Error en la entrada de datos. Por favor, intente de nuevo.");
	        scanner.next();
    }

   }
  
    private static void EditarCliente(Scanner scanner, ClienteController clienteController) {
	  
    	try {
    		System.out.print("Ingrese el DNI del cliente a editar: ");
    		int DNI = scanner.nextInt();
    		Cliente cliente = clienteController.getClienteByDNI(DNI);
    		if (cliente != null) {
    			System.out.print("Nuevo nombre y apellido: ");
    			String NuevoNombreApellido = scanner.next();
    			System.out.print("Nuevo Telefono: ");
                        int NuevoTelefono = scanner.nextInt();
    			cliente.setNombreApellido(NuevoNombreApellido);
    			cliente.setTelefono(NuevoTelefono);
                        clienteController.updateCliente(cliente);
    			System.out.println("Datos del cliente actualizados correctamente");
    		} else {
    			System.out.println("Cliente no encontrado");
    		}
    		
    	} catch (InputMismatchException e) {
    		System.out.println("Error en la entrada de datos. Por favor, intente de nuevo.");
            scanner.next();
    	}
    }
    
    private static void EliminarCliente(Scanner scanner, ClienteController clienteController) {
    	try {
    		System.out.print("Ingrese el DNI del cliente a eliminar: ");
    		int DNI = scanner.nextInt();
    		clienteController.deleteCliente(DNI);
    		System.out.println("Cliente eliminado con éxito");
    	} catch (InputMismatchException e) {
    		System.out.println("Error en la entrada de datos. Por favor, intente de nuevo.");
            scanner.next();
    	}
    }
    
    
    
    private static void CrearTurno(Scanner scanner, TurnoController turnoController) {
	  
	  try {
		  System.out.print("Dia del turno: ");
		  int Dia = scanner.nextInt();
		  System.out.print("Mes del turno: ");
		  int Mes = scanner.nextInt();
		  System.out.print("Hora del turno: ");
		  int Hora = scanner.nextInt();
		  
		  Turno NuevoTurno = new Turno(Dia, Mes, Hora);
		  
		  turnoController.addTurno(NuevoTurno);
		  System.out.println("Turno creado con éxito");
	  } catch (InputMismatchException e) {
	        System.out.println("Error en la entrada de datos. Por favor, intente de nuevo.");
	        scanner.next();
    }

   }
    
    
    
    
    private static void EditarTurno(Scanner scanner, TurnoController turnoController) {
	  
    	try {
    		System.out.print("Ingrese el Dia del turno a editar: ");
    		int Dia = scanner.nextInt();
    		Turno turno = turnoController.getTurnoByDia(Dia);
    		if (turno != null) {
    			System.out.print("Nuevo mes: ");
    			int NuevoMes = scanner.nextInt();
    			System.out.print("Nuevo hora: ");
                        int NuevaHora = scanner.nextInt();
    			turno.setMes(NuevoMes);
    			turno.setHora(NuevaHora);
                        turnoController.updateTurno(turno);
    			System.out.println("Datos del turno actualizados correctamente");
    		} else {
    			System.out.println("Turno no encontrado");
    		}
    		
    	} catch (InputMismatchException e) {
    		System.out.println("Error en la entrada de datos. Por favor, intente de nuevo.");
            scanner.next();
    	}
    }
    
    private static void EliminarTurno(Scanner scanner, TurnoController turnoController) {
    	try {
    		System.out.print("Ingrese el Dia del turno a eliminar: ");
    		int Dia = scanner.nextInt();
    		turnoController.deleteCliente(Dia);
    		System.out.println("Turno eliminado con éxito");
    	} catch (InputMismatchException e) {
    		System.out.println("Error en la entrada de datos. Por favor, intente de nuevo.");
            scanner.next();
    	}
    }
    
    private static void AsignarTurnoACliente(Scanner scanner, TurnoLista turnoLista, ClienteController clienteController) {
    	try {
    		System.out.print("Ingrese el DNI del cliente; ");
    		int DNI = scanner.nextInt();
    		Cliente cliente = clienteController.getClienteByDNI(DNI);
    		if (cliente != null) {
    			turnoLista.AsignarTurno(cliente);
    		} else {
    			System.out.println("Turno no encontrado");
    		}
    	} catch (InputMismatchException e) {
    		System.out.println("Error en la entrada de datos. Por favor, intente de nuevo.");
            scanner.next();
    	}
    }
    
    private static void ConsultarDatosCliente(Scanner scanner, ClienteController clienteController, ClienteView clienteView) {
        try {
            System.out.print("Ingrese el DNI del cliente a consultar: ");
            int dni = scanner.nextInt();
            Cliente cliente = clienteController.getClienteByDNI(dni);
            if (cliente != null) {
                clienteView.printClienteDetails(cliente);
            } else {
                System.out.println("Cliente no encontrado");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error en la entrada de datos. Por favor, intente de nuevo.");
            scanner.next(); // limpiar el scanner
        }
    }
    
    private static void ListarTodosLosClientes(ClienteController clienteController, ClienteView clienteView) {
        List<Cliente> clientes = clienteController.getAllClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            for (Cliente cliente : clientes) {
                clienteView.printClienteDetails(cliente);
            }
        }
    }
    
    private static void SeleccionarTurno(Scanner scanner, TurnoController turnoController, TurnoView turnoView) {
        try {
            System.out.print("Ingrese el Dia del turno a seleccionar: ");
            int Dia = scanner.nextInt();
            Turno turno = turnoController.getTurnoByDia(Dia);
            if (turno != null) {
                turnoView.printTurnoDetails(turno);
            } else {
                System.out.println("Turno no encontrado");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error en la entrada de datos. Por favor, intente de nuevo.");
            scanner.next(); // limpiar el scanner
        }
    }
    
    private static void ListarTodosLosTurnos(TurnoController turnoController, TurnoView turnoView) {
        List<Turno> turnos = turnoController.getAllTurnos();
        if (turnos.isEmpty()) {
            System.out.println("No hay turnos registrados");
        } else {
            for (Turno turno : turnos) {
                turnoView.printTurnoDetails(turno);
            }
        }
    }
    
    
}
