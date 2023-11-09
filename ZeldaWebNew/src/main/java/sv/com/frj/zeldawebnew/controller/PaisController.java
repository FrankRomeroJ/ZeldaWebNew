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
import sv.com.frj.zeldawebnew.models.entity.Pais;
import sv.com.frj.zeldawebnew.models.service.IPaisService;

@Controller
@RequestMapping("/views/pais")
public class PaisController {
	
	@Autowired
	private IPaisService paisService;

	

	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/")
	public String listarpais(Model model) {
		List<Pais> listadopais = paisService.listarPaisesPorNombrepais();
		model.addAttribute("titulo", "Lista de pais");
		model.addAttribute("pais", listadopais);

		return "/views/pais/listar";
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/listaactivos")
	public String listarpaisActivos(Model model) {
		List<Pais> listadopais = paisService.listarPaisesActivos();
		model.addAttribute("titulo", "Lista de paisActivos");
		model.addAttribute("pais", listadopais);

		return "/views/pais/listar";
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping("/create")
	public String crear(Model model) {

		Pais pais = new Pais();

		model.addAttribute("titulo", "Formulario: Nuevo Pais");
		model.addAttribute("pais", pais);

		return "/views/pais/frmCrear";
	}

	@Secured({ "ROLE_ADMIN" , "ROLE_USER" })
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Pais pais, 
			BindingResult result,
			Model model, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Pais");
			model.addAttribute("pais", pais);
			System.out.println("Existieron errores en el formulario");			
			return "/views/pais/frmCrear";
		}

		paisService.guardar(pais);
		System.out.println("pais guardado con exito!");
		attribute.addFlashAttribute("success", "Cliente guardado con exito!");
		return "redirect:/views/pais/";
	}

	@Secured({ "ROLE_ADMIN" , "ROLE_USER" })
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {
			
		Pais pais = null;
		
		if (id > 0) {
			pais = paisService.buscarPorId(id);
			
			if (pais == null) {
				System.out.println("Error: El ID del pais no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del pais no existe!");
				return "redirect:/views/pais/";
			}
		}else {
			System.out.println("Error: Error con el ID del pais");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del pais");
			return "redirect:/views/pais/";
		}
		
		if (pais.isEstatus()) {
			
			pais.setEstatus(false);
		}else {
			pais.setEstatus(true);
		}

		model.addAttribute("titulo", "Formulario: Editar pais");
		model.addAttribute("pais", pais);
		
		paisService.guardar(pais);
		

		return "redirect:/views/pais/";
	}

	@Secured({ "ROLE_ADMIN" , "ROLE_USER" })
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer id, RedirectAttributes attribute) {

		Pais pais = null;
		
		if (id > 0) {
			pais = paisService.buscarPorId(id);
			
			if (pais == null) {
				System.out.println("Error: El ID del pais no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del pais no existe!");
				return "redirect:/views/pais/";
			}
		}else {
			System.out.println("Error: Error con el ID del pais");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del pais!");
			return "redirect:/views/pais/";
		}		
		
		paisService.eliminar(id);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/pais/";
	}

}
