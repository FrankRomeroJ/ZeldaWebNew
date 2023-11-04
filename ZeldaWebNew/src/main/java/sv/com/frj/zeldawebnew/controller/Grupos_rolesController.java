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

import sv.com.frj.zeldawebnew.models.entity.Grupos_roles;
import sv.com.frj.zeldawebnew.models.service.IGrupos_rolesService;

@Controller
@RequestMapping("/views/grupos_roles")
public class Grupos_rolesController {

	@Autowired
	private IGrupos_rolesService grupos_rolesService;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/")
	public String listarGrupos_roles(Model model) {
		List<Grupos_roles> listadoGrupos_roles = grupos_rolesService.listarTodos();
		model.addAttribute("titulo", "Lista de los Grupos_roles");
		model.addAttribute("grupos_roles", listadoGrupos_roles);

		return "/views/grupos_roles/listar";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/create")
	public String crear(Model model) {

		Grupos_roles grupos_roles = new Grupos_roles();

		model.addAttribute("titulo", "Formulario: Nuevo Grupos_roles");
		model.addAttribute("grupos_roles", grupos_roles);

		return "/views/grupos_roles/frmCrear";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Grupos_roles grupos_roles, BindingResult result, Model model,
			RedirectAttributes attribute) {

		Grupos_roles miGruposRoles = new Grupos_roles();

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Grupo_roles");
			model.addAttribute("grupos_roles", grupos_roles);
			System.out.println("Existieron errores en el formulario");
			return "/views/grupos_roles/frmCrear";
		}
		miGruposRoles = grupos_roles;
		grupos_rolesService.guardar(miGruposRoles);
		System.out.println("Grupos_roles guardado con exito!");
		attribute.addFlashAttribute("success", "Grupos_roles guardado con exito!");
		return "redirect:/views/grupos_roles/";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/edit/{rol}")
	public String editar(@PathVariable("rol") String rol, Model model, RedirectAttributes attribute) {

		Grupos_roles grupos_roles = new Grupos_roles();

		grupos_roles = grupos_rolesService.buscarPorId(rol);

		if (grupos_roles == null) {
			System.out.println("Error: El ID del grupos_roles no existe!");
			attribute.addFlashAttribute("error", "ATENCION: El ID del gupos_roles no existe!");
			return "redirect:/views/grupos_roles/";
		}

		model.addAttribute("titulo", "Formulario: Editar Grupos_roles");
		model.addAttribute("grupos_roles", grupos_roles);

		return "/views/grupos_roles/frmCrear";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/delete/{rol}")
	public String eliminar(@PathVariable("rol") String rol, RedirectAttributes attribute) {

		Grupos_roles grupos_roles = null;

		if (rol == null) {
			grupos_roles = grupos_rolesService.buscarPorId(rol);

			if (grupos_roles == null) {
				System.out.println("Error: El ID del grupos_roles no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del grupos_roles no existe!");
				return "redirect:/views/grupos_roles/";
			}
		} else {
			System.out.println("Error: Error con el ID del Grupos_roles");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Grupo_roles!");
			return "redirect:/views/grupos_roles/";
		}

		grupos_rolesService.eliminar(rol);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/grupos_roles/";
	}

}
