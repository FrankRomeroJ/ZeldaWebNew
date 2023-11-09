package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Departamento;




	public interface IDepartamentoService {
		
		public List<Departamento> listarTodos();
		public void guardar(Departamento departamentos);
		public Departamento buscarPorId(Integer id);
		public void eliminar(Integer id);
		public List<Departamento> listarDepartamentoPorDescripcion();
		public List<Departamento> buscarPorIdPais(Integer idPais);
	}


