package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Users;
import sv.com.frj.zeldawebnew.models.repository.UsersRespository;
import sv.com.frj.zeldawebnew.models.service.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService {

	@Autowired
	private UsersRespository usersRepository;
	
	
	@Override
	public List<Users> listarTodos() {
		return (List<Users>) usersRepository.findAll();
	}

	@Override
	public void guardar(Users users) {
		usersRepository.save(users);
	}

	@Override
	public Users buscarPorId(Long id)  {		
		return usersRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id){		
		usersRepository.deleteById(id);
	}

	@Override
	public Users buscarPorUsername(String username) {
		
		Users users = null;
		
		users= usersRepository.findByUsername (username);
		
		return users;
	
		
	}


}
