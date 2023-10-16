package sv.com.frj.zeldawebnew.models.repository;

import org.springframework.data.repository.CrudRepository;

import sv.com.frj.zeldawebnew.models.entity.Users;

public interface UsersRespository extends CrudRepository<Users, Long> {

}
