package sv.com.frj.zeldawebnew.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sv.com.frj.zeldawebnew.models.entity.Departamentos;

@Repository
public interface DepartamentosRepository extends JpaRepository<Departamentos, Integer>{

	
	@Query("Select d from Departamentos d order by d.descripcion")
	List<Departamentos> ListOrederedByDescripcionAsc();
	
	List<Departamentos> findByPaises_Id(Integer idPaises);

}
