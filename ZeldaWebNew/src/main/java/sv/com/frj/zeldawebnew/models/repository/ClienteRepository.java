package sv.com.frj.zeldawebnew.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sv.com.frj.zeldawebnew.models.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
