package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.com.frj.zeldawebnew.models.entity.Municipios;
import sv.com.frj.zeldawebnew.models.repository.MunicipiosRepository;
import sv.com.frj.zeldawebnew.models.service.IMunicipiosService;

@Service
public class MunicipiosServiceImpl implements IMunicipiosService {
	
	@Autowired
	private MunicipiosRepository municipiosRepository;
	
	@Override
	public List<Municipios> listarTodos() {
		return (List<Municipios>) municipiosRepository.findAll();
	}

	@Override
	public void guardar(Municipios municipios) {
		municipiosRepository.save(municipios);
	}

	@Override
	public Municipios buscarPorId(Integer id)  {		
		return municipiosRepository.findById(id).orElse(null);
	}

	
	@Override
	public void eliminar(Integer id){		
		municipiosRepository.deleteById(id);
	}
	@Override
	public List<Municipios> listarMunicipiosPorDescripcion(){
		
		List<Municipios> listaMunicipios = null;
		
		listaMunicipios = municipiosRepository.ListOrederedByDescripcionAsc();
		
		return listaMunicipios;
	}

	@Override
	public List<Municipios> buscarPorIdDepartamentos(Integer idDepartamentos){
		
		return municipiosRepository.findByDepartamentos_Id(idDepartamentos);
		
	}
	
}
