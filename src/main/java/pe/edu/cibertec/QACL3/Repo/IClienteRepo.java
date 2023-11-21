package pe.edu.cibertec.QACL3.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.QACL3.Model.Cliente;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

}
