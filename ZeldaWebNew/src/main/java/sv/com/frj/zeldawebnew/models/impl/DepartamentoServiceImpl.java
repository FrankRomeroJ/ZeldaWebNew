package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.com.frj.zeldawebnew.models.entity.Departamento;
import sv.com.frj.zeldawebnew.models.repository.DepartamentoRepository;
import sv.com.frj.zeldawebnew.models.service.IDepartamentoService;


@Service
public class DepartamentoServiceImpl implements IDepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentosRepository;
	
	@Override
	public List<Departamento> listarTodos() {
		return (List<Departamento>) departamentosRepository.findAll();
	}

	@Override
	public void guardar(Departamento departamentos) {
		departamentosRepository.save(departamentos);
	}

	@Override
	public Departamento buscarPorId(Integer id)  {		
		return departamentosRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id){		
		departamentosRepository.deleteById(id);
	}

	@Override
	public List<Departamento> listarDepartamentoPorDescripcion(){
		
		List<Departamento> listaDepartamentos = null;
		
		listaDepartamentos = departamentosRepository.ListOrederedByDescripcionAsc();
		
		return listaDepartamentos;
	}
	
	@Override
	public List<Departamento> buscarPorIdPais(Integer idPais) {
		return departamentosRepository.findByPais_Id(idPais);
	}
}
