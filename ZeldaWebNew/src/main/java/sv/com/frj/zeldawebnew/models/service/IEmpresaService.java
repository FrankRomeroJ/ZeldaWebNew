package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Empresa;


public interface IEmpresaService {
	
	public List<Empresa> listarTodos();
	public void guardar(Empresa empresa);
	public Empresa buscarPorId(Integer id);
	public void eliminar(Integer Id);
	
}
