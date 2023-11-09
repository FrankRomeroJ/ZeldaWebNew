package sv.com.frj.zeldawebnew.models.service;

import java.util.List;


import sv.com.frj.zeldawebnew.models.entity.Pais;
import sv.com.frj.zeldawebnew.models.entity.Roles;



	public interface IPaisService {
		
		public List<Pais> listarTodos();
		public void guardar(Pais pais);
		public Pais buscarPorId(Integer id);
		public void eliminar(Integer id);
		public List<Pais> listarPaisesActivos();
		public List<Pais> listarPaisesPorNombrepais();
	}


