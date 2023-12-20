package sv.com.frj.zeldawebnew.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sv.com.frj.zeldawebnew.models.entity.Acc_PeriodoCont;
import sv.com.frj.zeldawebnew.models.entity.Acc_PeriodoContPK;

public interface Acc_PeriodoContRespository extends CrudRepository<Acc_PeriodoCont, Acc_PeriodoContPK> {
	
	@Query("Select a from Acc_PeriodoCont a order by a.llave desc" )
	List<Acc_PeriodoCont> findByLlaveDesc ();
	
}