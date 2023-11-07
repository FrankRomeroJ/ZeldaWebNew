package sv.com.frj.zeldawebnew.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.com.frj.zeldawebnew.models.entity.Paises;
import sv.com.frj.zeldawebnew.models.service.IPaisesService;

@Controller
@RequestMapping("/views/paises")
public class PaisesController {
	
	@Autowired
	private IPaisesService paisesService;

	

	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/")
	public String listarPaises(Model model) {
		List<Paises> listadoPaises = paisesService.listarPaisesPorNombrepais();
		model.addAttribute("titulo", "Lista de Paises");
		model.addAttribute("paises", listadoPaises);

		return "/views/paises/listar";
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/listaactivos")
	public String listarPaisesActivos(Model model) {
		List<Paises> listadoPaises = paisesService.listarPaisesActivos();
		model.addAttribute("titulo", "Lista de PaisesActivos");
		model.addAttribute("paises", listadoPaises);

		return "/views/paises/listar";
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping("/create")
	public String crear(Model model) {

		Paises paises = new Paises();

		model.addAttribute("titulo", "Formulario: Nuevo Pais");
		model.addAttribute("paises", paises);

		return "/views/paises/frmCrear";
	}

	@Secured({ "ROLE_ADMIN" , "ROLE_USER" })
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Paises paises, 
			BindingResult result,
			Model model, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Pais");
			model.addAttribute("paises", paises);
			System.out.println("Existieron errores en el formulario");			
			return "/views/paises/frmCrear";
		}

		paisesService.guardar(paises);
		System.out.println("paises guardado con exito!");
		attribute.addFlashAttribute("success", "Cliente guardado con exito!");
		return "redirect:/views/paises/";
	}

	@Secured({ "ROLE_ADMIN" , "ROLE_USER" })
	@GetMapping("/edit/{idpais}")
	public String editar(@PathVariable("idpais") Integer idpais, Model model, RedirectAttributes attribute) {
			
		Paises paises = null;
		
		if (idpais > 0) {
			paises = paisesService.buscarPorId(idpais);
			
			if (paises == null) {
				System.out.println("Error: El ID del paises no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del paises no existe!");
				return "redirect:/views/paises/";
			}
		}else {
			System.out.println("Error: Error con el ID del Paises");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del paises");
			return "redirect:/views/paises/";
		}
		
		if (paises.isEstatus()) {
			
			paises.setEstatus(false);
		}else {
			paises.setEstatus(true);
		}

		model.addAttribute("titulo", "Formulario: Editar Paises");
		model.addAttribute("paises", paises);
		
		paisesService.guardar(paises);
		

		return "redirect:/views/paises/";
	}

	@Secured({ "ROLE_ADMIN" , "ROLE_USER" })
	@GetMapping("/delete/{idpais}")
	public String eliminar(@PathVariable("idpaises") Integer idpais, RedirectAttributes attribute) {

		Paises paises = null;
		
		if (idpais > 0) {
			paises = paisesService.buscarPorId(idpais);
			
			if (paises == null) {
				System.out.println("Error: El ID del pais no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del pais no existe!");
				return "redirect:/views/paises/";
			}
		}else {
			System.out.println("Error: Error con el ID del Paises");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Paises!");
			return "redirect:/views/paises/";
		}		
		
		paisesService.eliminar(idpais);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/paises/";
	}

}
