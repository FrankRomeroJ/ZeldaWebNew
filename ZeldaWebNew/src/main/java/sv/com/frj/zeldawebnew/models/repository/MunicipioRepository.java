package sv.com.frj.zeldawebnew.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sv.com.frj.zeldawebnew.models.entity.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{

	
	@Query("Select m from Municipio m order by m.descripcion")
	List<Municipio> ListOrederedByDescripcionAsc();
	
	List<Municipio> findByDepartamento_Id(Integer IdDepartamento);

}
