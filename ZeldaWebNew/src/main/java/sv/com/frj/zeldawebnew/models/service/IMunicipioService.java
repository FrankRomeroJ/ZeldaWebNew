package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Municipio;


	public interface IMunicipioService {
		
		public List<Municipio> listarTodos();
		public void guardar(Municipio municipio);
		public Municipio buscarPorId(Integer id);
		public void eliminar(Integer id);
		public List<Municipio> listarMunicipioPorDescripcion();
		public List<Municipio> buscarPorIdDepartamento(Integer idDepartamento);
	}


