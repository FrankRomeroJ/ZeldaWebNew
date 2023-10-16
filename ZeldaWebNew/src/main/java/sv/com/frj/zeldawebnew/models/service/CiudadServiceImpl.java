package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Ciudad;
import sv.com.frj.zeldawebnew.models.repository.CiudadRespository;

@Service
public class CiudadServiceImpl implements ICiudadService {

	@Autowired
	private CiudadRespository ciudadRepository;
	
	@Override
	public List<Ciudad> listaCiudades() {
		
		return (List<Ciudad>) ciudadRepository.findAll();
	}

}
