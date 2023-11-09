package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Empresa;
import sv.com.frj.zeldawebnew.models.repository.EmpresaRepository;
import sv.com.frj.zeldawebnew.models.service.IEmpresaService;


@Service
public class EmpresaServiceImpl implements IEmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public List<Empresa> listarTodos() {
		return (List<Empresa>) empresaRepository.findAll();
	}

	@Override
	public void guardar(Empresa empresa) {
		empresaRepository.save(empresa);
	}

	@Override
	public Empresa buscarPorId(Integer id)  {		
		return empresaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id){		
		empresaRepository.deleteById(id);
	}

}
