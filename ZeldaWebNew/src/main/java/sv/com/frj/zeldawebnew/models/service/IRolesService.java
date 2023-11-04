package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Cliente;
import sv.com.frj.zeldawebnew.models.entity.Roles;



public interface IRolesService {
	
	public List<Roles> listarTodos();
	public void guardar(Roles roles);
	public Roles buscarPorId(Long id);
	public void eliminar(Long id);
	
}
