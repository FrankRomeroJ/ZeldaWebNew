package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Empresas;


public interface IEmpresasService {
	
	public List<Empresas> listarTodos();
	public void guardar(Empresas empresas);
	public Empresas buscarPorId(Integer id);
	public void eliminar(Integer Id);
	
}
