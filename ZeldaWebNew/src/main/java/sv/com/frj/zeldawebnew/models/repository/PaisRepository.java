package sv.com.frj.zeldawebnew.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sv.com.frj.zeldawebnew.models.entity.Pais;


@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer>{

	@Query("Select p from Pais p where p.estatus = 1" )
	List<Pais> findByEstatusActivo();
	
	@Query("Select p from Pais p order by p.nombrepais")
	List<Pais> ListOrederedByNombrepaisAsc();

}
