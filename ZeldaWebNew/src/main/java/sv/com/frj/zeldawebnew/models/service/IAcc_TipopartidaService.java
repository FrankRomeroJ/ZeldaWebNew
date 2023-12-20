package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Acc_Tipopartida;

public interface IAcc_TipopartidaService {
	
	public List<Acc_Tipopartida> listarTodos();
	public void guardar(Acc_Tipopartida tipopartida);
	public  Acc_Tipopartida buscarPorId(String codigo);
	public void eliminar(String codigo);
	
}
