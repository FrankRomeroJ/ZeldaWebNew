package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Grupos_roles;

public interface IGrupos_rolesService {
	
	public List<Grupos_roles> listarTodos();
	public void guardar(Grupos_roles grupos_roles);
	public 	Grupos_roles buscarPorId(String rol);
	public void eliminar(String rol);
	
}
