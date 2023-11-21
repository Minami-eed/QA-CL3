package pe.edu.cibertec.QACL3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import pe.edu.cibertec.QACL3.Model.Cliente;
import pe.edu.cibertec.QACL3.Service.IClienteService;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cliente")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, clientes.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obtenerCliente(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(clienteService.obtenerCliente(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.registrarCliente(cliente);
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> modificarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        Cliente newCliente = clienteService.modificarCliente(id, cliente);
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(clienteService.eliminarCliente(id), HttpStatus.OK);
    }
}
