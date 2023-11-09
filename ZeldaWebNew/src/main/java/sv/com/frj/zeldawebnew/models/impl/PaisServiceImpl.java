package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Pais;

import sv.com.frj.zeldawebnew.models.repository.PaisRepository;

import sv.com.frj.zeldawebnew.models.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public List<Pais> listarTodos() {
		return (List<Pais>) paisRepository.findAll();
	}

	@Override
	public void guardar(Pais pais) {
		paisRepository.save(pais);
	}

	@Override
	public Pais buscarPorId(Integer id)  {		
		return paisRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id){		
		paisRepository.deleteById(id);
	}
	
	@Override
	public List<Pais> listarPaisesActivos(){
		
		List<Pais> listaPaises = null;
		
		listaPaises = paisRepository.findByEstatusActivo();
		
		return listaPaises;
	}

	@Override
	public List<Pais> listarPaisesPorNombrepais(){
		
		List<Pais> listaPais = null;
		
		listaPais = paisRepository.ListOrederedByNombrepaisAsc();
		
		return listaPais;
	}
}
