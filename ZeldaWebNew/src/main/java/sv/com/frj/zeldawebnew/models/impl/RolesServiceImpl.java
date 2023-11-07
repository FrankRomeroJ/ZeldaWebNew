package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Roles;
import sv.com.frj.zeldawebnew.models.repository.RolesRepository;
import sv.com.frj.zeldawebnew.models.service.IRolesService;

@Service
public class RolesServiceImpl implements IRolesService {
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public List<Roles> listarTodos() {
		return (List<Roles>) rolesRepository.findAll();
	}

	@Override
	public void guardar(Roles roles) {
		rolesRepository.save(roles);
	}

	@Override
	public Roles buscarPorId(Long id)  {		
		return rolesRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id){		
		rolesRepository.deleteById(id);
	}

}
