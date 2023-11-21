package pe.edu.cibertec.QACL3.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.edu.cibertec.QACL3.Model.Cliente;
import pe.edu.cibertec.QACL3.Repo.IClienteRepo;
import pe.edu.cibertec.QACL3.Service.IClienteService;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteRepo clienteRepo;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente obtenerCliente(Integer id) {
        return clienteRepo.findById(id).get();
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente modificarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public String eliminarCliente(Integer id) {
        clienteRepo.deleteById(id);
        return "Cliente Eliminado";
    }
}
