package sv.com.frj.zeldawebnew.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sv.com.frj.zeldawebnew.models.entity.Municipios;

@Repository
public interface MunicipiosRepository extends JpaRepository<Municipios, Integer>{

	
	@Query("Select m from Municipios m order by m.descripcion")
	List<Municipios> ListOrederedByDescripcionAsc();
	
	List<Municipios> findByDepartamentos_Id(Integer IdDepartamentos);

}
