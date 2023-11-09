package sv.com.frj.zeldawebnew.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.com.frj.zeldawebnew.models.entity.Municipio;
import sv.com.frj.zeldawebnew.models.service.IMunicipioService;


@Controller
@RequestMapping("/views/municipio")
public class MunicipioController {
	
	@Autowired
	private IMunicipioService municipioService;

	

	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/")
	public String listarMunicipio(Model model) {
		List<Municipio> listadoMunicipio = municipioService.listarTodos();
		model.addAttribute("titulo", "Lista de Municipios");
		model.addAttribute("municipio", listadoMunicipio);

		return "/views/municipio/listar";
	}


}
