package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Acc_Tipopartida;
import sv.com.frj.zeldawebnew.models.entity.Grupos_roles;
import sv.com.frj.zeldawebnew.models.repository.Acc_TipopartidaRespository;
import sv.com.frj.zeldawebnew.models.repository.Grupos_rolesRespository;
import sv.com.frj.zeldawebnew.models.service.IAcc_TipopartidaService;
import sv.com.frj.zeldawebnew.models.service.IGrupos_rolesService;



@Service
public class Acc_TipopartidaServiceImpl implements IAcc_TipopartidaService {
	
	@Autowired
	private Acc_TipopartidaRespository tipopartidaRepository;
	
	@Override
	public List<Acc_Tipopartida> listarTodos() {
		return (List<Acc_Tipopartida>) tipopartidaRepository.findAll();
	}

	@Override
	public void guardar(Acc_Tipopartida tipopartida) {
		tipopartidaRepository.save(tipopartida);
	}

	@Override
	public Acc_Tipopartida buscarPorId(String codigo)  {		
		return tipopartidaRepository.findById(codigo).orElse(null);
	}

	@Override
	public void eliminar(String codigo){		
		tipopartidaRepository.deleteById(codigo);
	}

}
