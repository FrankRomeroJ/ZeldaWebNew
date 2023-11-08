package sv.com.frj.zeldawebnew.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sv.com.frj.zeldawebnew.models.entity.Paises;


@Repository
public interface PaisesRepository extends CrudRepository<Paises, Integer>{

	@Query("Select p from Paises p where p.estatus = 1" )
	List<Paises> findByEstatusActivo();
	
	@Query("Select p from Paises p order by p.nombrepais")
	List<Paises> ListOrederedByNombrepaisAsc();

}
