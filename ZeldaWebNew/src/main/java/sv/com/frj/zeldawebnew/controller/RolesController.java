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

import sv.com.frj.zeldawebnew.models.entity.Ciudad;
import sv.com.frj.zeldawebnew.models.entity.Cliente;
import sv.com.frj.zeldawebnew.models.entity.Grupos_roles;
import sv.com.frj.zeldawebnew.models.entity.Roles;
import sv.com.frj.zeldawebnew.models.entity.Users;
import sv.com.frj.zeldawebnew.models.service.ICiudadService;
import sv.com.frj.zeldawebnew.models.service.IClienteService;
import sv.com.frj.zeldawebnew.models.service.IGrupos_rolesService;
import sv.com.frj.zeldawebnew.models.service.IRolesService;
import sv.com.frj.zeldawebnew.models.service.IUsersService;

@Controller
@RequestMapping("/views/roles")
public class RolesController {

	@Autowired
	private IRolesService rolesService;

	@Autowired
	private IUsersService usersService;

	@Autowired
	private IGrupos_rolesService grupos_rolesService;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/")
	public String listarClientes(Model model) {
		List<Roles> listadoRoles = rolesService.listarTodos();
		model.addAttribute("titulo", "Lista de Roles");
		model.addAttribute("roles", listadoRoles);

		return "/views/roles/listar";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/create")
	public String crear(Model model) {

		Roles roles = new Roles();
		List<Users> listusers = usersService.listarTodos();
		List<Grupos_roles> listgrupos_roles = grupos_rolesService.listarTodos();

		model.addAttribute("titulo", "Formulario: Nuevo Rol");
		model.addAttribute("roles", roles);
		model.addAttribute("grupos_roles",listgrupos_roles);
		model.addAttribute("users", listusers);

		return "/views/roles/frmCrear";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Roles roles, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Rol");
			model.addAttribute("roles", roles);
			System.out.println("Existieron errores en el formulario");
			return "/views/roles/frmCrear";
		}

		rolesService.guardar(roles);
		System.out.println("Cliente guardado con exito!");
		attribute.addFlashAttribute("success", "Rol guardado con exito!");
		return "redirect:/views/roles/";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable Long id, Model model, RedirectAttributes attribute) {

		Roles roles = null;

		List<Users> listusers = usersService.listarTodos();

		List<Grupos_roles> listgrupos_roles = grupos_rolesService.listarTodos();
		
		if (id > 0) {
			roles = rolesService.buscarPorId(id);

			if (roles == null) {
				System.out.println("Error: El ID del Rol no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del roles no existe!");
				return "redirect:/views/roles/";
			}
		} else {
			System.out.println("Error: Error con el ID del Roles");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del roles");
			return "redirect:/views/roles/";
		}

		
		model.addAttribute("titulo", "Formulario: Editar Cliente");
		model.addAttribute("roles", roles);
		model.addAttribute("users",listusers);
		model.addAttribute("grupos_roles",listgrupos_roles);

		return "/views/roles/frmCrear";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes attribute) {

		Roles roles = null;

		if (id > 0) {
			roles = rolesService.buscarPorId(id);

			if (roles == null) {
				System.out.println("Error: El ID del roles no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del roles no existe!");
				return "redirect:/views/roles/";
			}
		} else {
			System.out.println("Error: Error con el ID del Roles");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Roles!");
			return "redirect:/views/roles/";
		}

		rolesService.eliminar(id);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/roles/";
	}

}
