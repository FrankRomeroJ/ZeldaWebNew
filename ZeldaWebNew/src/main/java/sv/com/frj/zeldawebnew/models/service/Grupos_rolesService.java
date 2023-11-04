package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Grupos_roles;
import sv.com.frj.zeldawebnew.models.repository.Grupos_rolesRespository;



@Service
public class Grupos_rolesService implements IGrupos_rolesService {
	
	@Autowired
	private Grupos_rolesRespository grupos_rolesRepository;
	
	@Override
	public List<Grupos_roles> listarTodos() {
		return (List<Grupos_roles>) grupos_rolesRepository.findAll();
	}

	@Override
	public void guardar(Grupos_roles grupos_roles) {
		grupos_rolesRepository.save(grupos_roles);
	}

	@Override
	public Grupos_roles buscarPorId(String rol)  {		
		return grupos_rolesRepository.findById(rol).orElse(null);
	}

	@Override
	public void eliminar(String rol){		
		grupos_rolesRepository.deleteById(rol);
	}

}
