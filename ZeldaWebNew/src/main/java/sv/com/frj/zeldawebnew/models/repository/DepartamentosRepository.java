package sv.com.frj.zeldawebnew.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sv.com.frj.zeldawebnew.models.entity.Departamentos;

public interface DepartamentosRepository extends CrudRepository<Departamentos, Integer>{

	
	@Query("Select d from Departamentos d order by d.descripcion")
	List<Departamentos> ListOrederedByDescripcionAsc();

}
