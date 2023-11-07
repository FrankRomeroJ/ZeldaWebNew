package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Municipios;


	public interface IMunicipiosService {
		
		public List<Municipios> listarTodos();
		public void guardar(Municipios nunicipios);
		public Municipios buscarPorId(Integer reg_municipio);
		public void eliminar(Integer reg_municipio);
		public List<Municipios> listarMunicipiosPorDescripcion();
	}


