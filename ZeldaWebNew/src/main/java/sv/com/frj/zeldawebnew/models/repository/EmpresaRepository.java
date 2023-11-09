package sv.com.frj.zeldawebnew.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sv.com.frj.zeldawebnew.models.entity.Cliente;
import sv.com.frj.zeldawebnew.models.entity.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
