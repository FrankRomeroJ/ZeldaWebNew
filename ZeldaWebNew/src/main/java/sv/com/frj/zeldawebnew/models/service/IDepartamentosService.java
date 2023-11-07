package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Departamentos;




	public interface IDepartamentosService {
		
		public List<Departamentos> listarTodos();
		public void guardar(Departamentos departamentos);
		public Departamentos buscarPorId(Integer reg_depto);
		public void eliminar(Integer reg_depto);
		public List<Departamentos> listarDepartamentosPorDescripcion();
	}


