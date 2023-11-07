package sv.com.frj.zeldawebnew.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.frj.zeldawebnew.models.entity.Paises;

import sv.com.frj.zeldawebnew.models.repository.PaisesRepository;

import sv.com.frj.zeldawebnew.models.service.IPaisesService;

@Service
public class PaisesServiceImpl implements IPaisesService {
	
	@Autowired
	private PaisesRepository paisesRepository;
	
	@Override
	public List<Paises> listarTodos() {
		return (List<Paises>) paisesRepository.findAll();
	}

	@Override
	public void guardar(Paises paises) {
		paisesRepository.save(paises);
	}

	@Override
	public Paises buscarPorId(Integer idpais)  {		
		return paisesRepository.findById(idpais).orElse(null);
	}

	@Override
	public void eliminar(Integer id){		
		paisesRepository.deleteById(id);
	}
	
	@Override
	public List<Paises> listarPaisesActivos(){
		
		List<Paises> listaPaises = null;
		
		listaPaises = paisesRepository.findByEstatusActivo();
		
		return listaPaises;
	}

	@Override
	public List<Paises> listarPaisesPorNombrepais(){
		
		List<Paises> listaPaises = null;
		
		listaPaises = paisesRepository.ListOrederedByNombrepaisAsc();
		
		return listaPaises;
	}
}
