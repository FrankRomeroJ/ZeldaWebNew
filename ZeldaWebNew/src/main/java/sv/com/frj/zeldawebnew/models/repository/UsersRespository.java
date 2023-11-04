package sv.com.frj.zeldawebnew.models.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sv.com.frj.zeldawebnew.models.entity.Users;

public interface UsersRespository extends CrudRepository<Users, Long> {
	
	@Query("Select u from Users u where u.username = ?1" )
	Users findByUsername (String username);

}