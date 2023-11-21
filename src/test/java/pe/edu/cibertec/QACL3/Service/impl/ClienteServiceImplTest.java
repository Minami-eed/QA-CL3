package pe.edu.cibertec.QACL3.Service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import pe.edu.cibertec.QACL3.Model.Cliente;
import pe.edu.cibertec.QACL3.Repo.IClienteRepo;

@WebMvcTest(ClienteServiceImplTest.class)
public class ClienteServiceImplTest {
    @InjectMocks
    ClienteServiceImpl clienteServiceImpl;

    @Mock
    IClienteRepo clienteRepo;

    @BeforeEach
    void setup() {
        clienteServiceImpl = new ClienteServiceImpl(clienteRepo);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void listarClientes() {
        List<Cliente> clientes = generarListaClientes();
        when(clienteRepo.findAll()).thenReturn(clientes);
        List<Cliente> clientesResponse = clienteServiceImpl.listarClientes();
        assertEquals(1, clientesResponse.size());
    }

    @Test
    void obtenerCliente() {
        Cliente cliente = generarCliente();

        when(clienteRepo.findById(anyInt())).thenReturn(Optional.ofNullable(cliente));
        Cliente clienteResponse = clienteServiceImpl.obtenerCliente(1);
        assertEquals(1, clienteResponse.getId());
    }

    @Test
    void registrarCliente() {
        Cliente cliente = generarCliente();

        when(clienteRepo.save(any(Cliente.class))).thenReturn(cliente);
        Cliente ClienteResponse = clienteServiceImpl.registrarCliente(cliente);
        assertEquals(1, ClienteResponse.getId());
    }

    @Test
    void modificarCliente() {
        Cliente cliente = generarCliente();

        when(clienteRepo.save(any(Cliente.class))).thenReturn(cliente);
        Cliente clienteResponse = clienteServiceImpl.modificarCliente(null, cliente);
        assertEquals(1, clienteResponse.getId());
    }

    @Test
    void eliminarCliente() {
        doNothing().when(clienteRepo).deleteById(anyInt());
        String clienteResponse = clienteServiceImpl.eliminarCliente(1);
        assertEquals("Cliente Eliminado", clienteResponse);
    }

    List<Cliente> generarListaClientes() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Nombre");
        cliente.setApellido("Apellido");
        cliente.setDni("12345678");
        cliente.setTelefono("987654321");
        Cliente cliente2 = new Cliente();
        cliente2.setId(1);
        cliente2.setNombre("mi nombre 2");
        cliente2.setApellido("mi Apellido 2");
        cliente2.setDni("12345678");
        cliente2.setTelefono("963852741");
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        clientes.add(cliente2);

        return clientes;
    }

    Cliente generarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Nombre 1");
        cliente.setApellido("Apellido 1");
        cliente.setDni("12345678");
        cliente.setTelefono("987654321");

        return cliente;
    }
}