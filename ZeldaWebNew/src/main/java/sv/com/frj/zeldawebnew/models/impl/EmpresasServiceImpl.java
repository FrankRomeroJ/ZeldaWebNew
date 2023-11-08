package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Empresas;
import sv.com.frj.zeldawebnew.models.repository.EmpresasRepository;
import sv.com.frj.zeldawebnew.models.service.IEmpresasService;


@Service
public class EmpresasServiceImpl implements IEmpresasService {
	
	@Autowired
	private EmpresasRepository empresasRepository;
	
	@Override
	public List<Empresas> listarTodos() {
		return (List<Empresas>) empresasRepository.findAll();
	}

	@Override
	public void guardar(Empresas empresas) {
		empresasRepository.save(empresas);
	}

	@Override
	public Empresas buscarPorId(Integer id)  {		
		return empresasRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id){		
		empresasRepository.deleteById(id);
	}

}
