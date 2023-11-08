package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Departamentos;




	public interface IDepartamentosService {
		
		public List<Departamentos> listarTodos();
		public void guardar(Departamentos departamentos);
		public Departamentos buscarPorId(Integer idPaises);
		public void eliminar(Integer idPaises);
		public List<Departamentos> listarDepartamentosPorDescripcion();
		public List<Departamentos> buscarPorIdPaises(Integer idPaises);
	}


