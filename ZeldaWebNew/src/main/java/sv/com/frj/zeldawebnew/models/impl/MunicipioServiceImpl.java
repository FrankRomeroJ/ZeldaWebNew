package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.com.frj.zeldawebnew.models.entity.Municipio;
import sv.com.frj.zeldawebnew.models.repository.MunicipioRepository;
import sv.com.frj.zeldawebnew.models.service.IMunicipioService;

@Service
public class MunicipioServiceImpl implements IMunicipioService {
	
	@Autowired
	private MunicipioRepository municipioRepository;
	
	@Override
	public List<Municipio> listarTodos() {
		return (List<Municipio>) municipioRepository.findAll();
	}

	@Override
	public void guardar(Municipio municipio) {
		municipioRepository.save(municipio);
	}

	@Override
	public Municipio buscarPorId(Integer id)  {		
		return municipioRepository.findById(id).orElse(null);
	}

	
	@Override
	public void eliminar(Integer id){		
		municipioRepository.deleteById(id);
	}
	@Override
	public List<Municipio> listarMunicipioPorDescripcion(){
		
		List<Municipio> listaMunicipios = null;
		
		listaMunicipios = municipioRepository.ListOrederedByDescripcionAsc();
		
		return listaMunicipios;
	}

	@Override
	public List<Municipio> buscarPorIdDepartamento(Integer idDepartamento){
		
		return municipioRepository.findByDepartamento_Id(idDepartamento);
		
	}
	
}
