package sv.com.frj.zeldawebnew.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.com.frj.zeldawebnew.models.entity.Municipios;
import sv.com.frj.zeldawebnew.models.service.IMunicipiosService;


@Controller
@RequestMapping("/views/municipios")
public class MunicipiosController {
	
	@Autowired
	private IMunicipiosService municipiosService;

	

	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/")
	public String listarMunicipios(Model model) {
		List<Municipios> listadoMunicipios = municipiosService.listarTodos();
		model.addAttribute("titulo", "Lista de Municipios");
		model.addAttribute("municipios", listadoMunicipios);

		return "/views/municipios/listar";
	}


}
