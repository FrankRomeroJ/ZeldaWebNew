package sv.com.frj.zeldawebnew.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.com.frj.zeldawebnew.models.entity.Departamentos;
import sv.com.frj.zeldawebnew.models.service.IDepartamentosService;


@Controller
@RequestMapping("/views/departamentos")
public class DepartamentosController {
	
	@Autowired
	private IDepartamentosService departamentosService;

	

	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/")
	public String listarDepartamentos(Model model) {
		List<Departamentos> listadoDepartamentos = departamentosService.listarTodos();
		model.addAttribute("titulo", "Lista de Departamentos");
		model.addAttribute("departamentos", listadoDepartamentos);

		return "/views/departamentos/listar";
	}


}
