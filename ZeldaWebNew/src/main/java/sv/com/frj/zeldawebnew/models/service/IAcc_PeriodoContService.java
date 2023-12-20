package sv.com.frj.zeldawebnew.models.service;

import java.util.List;

import sv.com.frj.zeldawebnew.models.entity.Acc_PeriodoCont;
import sv.com.frj.zeldawebnew.models.entity.Acc_PeriodoContPK;


public interface IAcc_PeriodoContService {
	
	public List<Acc_PeriodoCont> listarTodos();
	public void guardar(Acc_PeriodoCont periodocont);
	public  Acc_PeriodoCont buscarPorId(Acc_PeriodoContPK llave);
	public void eliminar(Acc_PeriodoContPK llave);
	public List<Acc_PeriodoCont> listarTodosDesc();
	
}
