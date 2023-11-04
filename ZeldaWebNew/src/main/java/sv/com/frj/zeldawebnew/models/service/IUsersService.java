package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Users;

public interface IUsersService {
	
	public List<Users> listarTodos();
	public void guardar(Users users);
	public Users buscarPorId(Long id);
	public void eliminar(Long id);
	public Users buscarPorUsername(String username);
}
