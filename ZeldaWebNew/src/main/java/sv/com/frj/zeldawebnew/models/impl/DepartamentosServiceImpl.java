package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Departamentos;
import sv.com.frj.zeldawebnew.models.repository.DepartamentosRepository;
import sv.com.frj.zeldawebnew.models.service.IDepartamentosService;

@Service
public class DepartamentosServiceImpl implements IDepartamentosService {
	
	@Autowired
	private DepartamentosRepository departamentosRepository;
	
	@Override
	public List<Departamentos> listarTodos() {
		return (List<Departamentos>) departamentosRepository.findAll();
	}

	@Override
	public void guardar(Departamentos departamentos) {
		departamentosRepository.save(departamentos);
	}

	@Override
	public Departamentos buscarPorId(Integer reg_depto)  {		
		return departamentosRepository.findById(reg_depto).orElse(null);
	}

	@Override
	public void eliminar(Integer reg_depto){		
		departamentosRepository.deleteById(reg_depto);
	}

	@Override
	public List<Departamentos> listarDepartamentosPorDescripcion(){
		
		List<Departamentos> listaDepartamentos = null;
		
		listaDepartamentos = departamentosRepository.ListOrederedByDescripcionAsc();
		
		return listaDepartamentos;
	}
}
