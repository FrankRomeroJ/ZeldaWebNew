package sv.com.frj.zeldawebnew.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sv.com.frj.zeldawebnew.models.entity.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

	
	@Query("Select d from Departamento d order by d.descripcion")
	List<Departamento> ListOrederedByDescripcionAsc();
	
	List<Departamento> findByPais_Id(Integer idPais);

}
