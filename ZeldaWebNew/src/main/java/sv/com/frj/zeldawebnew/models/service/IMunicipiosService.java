package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Municipios;


	public interface IMunicipiosService {
		
		public List<Municipios> listarTodos();
		public void guardar(Municipios municipios);
		public Municipios buscarPorId(Integer id);
		public void eliminar(Integer id);
		public List<Municipios> listarMunicipiosPorDescripcion();
		public List<Municipios> buscarPorIdDepartamentos(Integer idDepartamentos);
	}


