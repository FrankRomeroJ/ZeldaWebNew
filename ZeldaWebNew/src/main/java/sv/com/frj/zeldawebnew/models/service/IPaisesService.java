package sv.com.frj.zeldawebnew.models.service;

import java.util.List;


import sv.com.frj.zeldawebnew.models.entity.Paises;
import sv.com.frj.zeldawebnew.models.entity.Roles;



	public interface IPaisesService {
		
		public List<Paises> listarTodos();
		public void guardar(Paises paises);
		public Paises buscarPorId(Integer id);
		public void eliminar(Integer id);
		public List<Paises> listarPaisesActivos();
		public List<Paises> listarPaisesPorNombrepais();
	}


