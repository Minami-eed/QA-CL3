package pe.edu.cibertec.QACL3.Service;

import java.util.List;

import pe.edu.cibertec.QACL3.Model.Cliente;

public interface IClienteService {
    public List<Cliente> listarClientes();

    public Cliente obtenerCliente(Integer id);

    public Cliente registrarCliente(Cliente cliente);

    public Cliente modificarCliente(Integer id, Cliente cliente);

    public String eliminarCliente(Integer id);
}
