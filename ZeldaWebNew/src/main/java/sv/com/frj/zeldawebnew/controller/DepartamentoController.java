package sv.com.frj.zeldawebnew.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.com.frj.zeldawebnew.models.entity.Departamento;
import sv.com.frj.zeldawebnew.models.service.IDepartamentoService;



@Controller
@RequestMapping("/views/departamento")
public class DepartamentoController {
	
	@Autowired
	private IDepartamentoService departamentoService;

	

	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/")
	public String listarDepartamentos(Model model) {
		List<Departamento> listadoDepartamento = departamentoService.listarTodos();
		model.addAttribute("titulo", "Lista de Departamentos");
		model.addAttribute("departamento", listadoDepartamento);

		return "/views/departamento/listar";
	}


}
