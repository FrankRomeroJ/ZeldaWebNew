package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Acc_PeriodoCont;
import sv.com.frj.zeldawebnew.models.entity.Acc_PeriodoContPK;
import sv.com.frj.zeldawebnew.models.entity.Acc_Tipopartida;
import sv.com.frj.zeldawebnew.models.entity.Grupos_roles;
import sv.com.frj.zeldawebnew.models.repository.Acc_PeriodoContRespository;
import sv.com.frj.zeldawebnew.models.repository.Acc_TipopartidaRespository;
import sv.com.frj.zeldawebnew.models.repository.Grupos_rolesRespository;
import sv.com.frj.zeldawebnew.models.service.IAcc_PeriodoContService;
import sv.com.frj.zeldawebnew.models.service.IAcc_TipopartidaService;
import sv.com.frj.zeldawebnew.models.service.IGrupos_rolesService;



@Service
public class Acc_PeriodoContServiceImpl implements IAcc_PeriodoContService {
	
	@Autowired
	private Acc_PeriodoContRespository periodocontRepository;
	
	@Override
	public List<Acc_PeriodoCont> listarTodos() {
		return (List<Acc_PeriodoCont>) periodocontRepository.findAll();
	}

	@Override
	public void guardar(Acc_PeriodoCont periodocont) {
		periodocontRepository.save(periodocont);
	}

	@Override
	public Acc_PeriodoCont buscarPorId(Acc_PeriodoContPK llave)  {		
		return periodocontRepository.findById(llave).orElse(null);
	}

	@Override
	public void eliminar(Acc_PeriodoContPK llave){		
		periodocontRepository.deleteById(llave);
	}
	
	@Override
	public List<Acc_PeriodoCont> listarTodosDesc() {
		return (List<Acc_PeriodoCont>) periodocontRepository.findByLlaveDesc();
	}

}
