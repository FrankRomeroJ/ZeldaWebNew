package sv.com.frj.zeldawebnew.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.frj.zeldawebnew.models.entity.Users;
import sv.com.frj.zeldawebnew.models.service.IUsersService;

@Controller
@RequestMapping("/views/users")
public class UsersController {

	@Autowired
	private IUsersService usersService;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/")
	public String listarUsers(Model model) {
		List<Users> listadoUsers = usersService.listarTodos();
		model.addAttribute("titulo", "Lista de Usuarios");
		model.addAttribute("users", listadoUsers);

		return "/views/users/listar";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/create")
	public String crear(Model model) {

		Users users = new Users();

		model.addAttribute("titulo", "Formulario: Nuevo Users");
		model.addAttribute("users", users);

		return "/views/users/frmCrear";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Users users, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Users");
			model.addAttribute("users", users);
			System.out.println("Existieron errores en el formulario");
			return "/views/users/frmCrear";
		}

		Users miUser = new Users();

		if (users.getId() != null) {

			miUser = usersService.buscarPorId(users.getId());

			if (miUser.getPassword() == null) {

				users.setPassword(encoder.encode(users.getPassword()));

			} else if (miUser.getPassword() != users.getPassword()) {

				users.setPassword(encoder.encode(users.getPassword()));
			}

		}

		usersService.guardar(users);
		System.out.println("Users guardado con exito!");
		attribute.addFlashAttribute("success", "Users guardado con exito!");
		return "redirect:/views/users/";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idUsers, Model model, RedirectAttributes attribute) {

		Users users = null;

		if (idUsers > 0) {
			users = usersService.buscarPorId(idUsers);

			if (users == null) {
				System.out.println("Error: El ID del users no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del users no existe!");
				return "redirect:/views/users/";
			}
		} else {
			System.out.println("Error: Error con el ID del Users");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del users");
			return "redirect:/views/users/";
		}

		// List<Ciudad> listCiudades = ciudadService.listaCiudades();

		model.addAttribute("titulo", "Formulario: Editar Users");
		model.addAttribute("users", users);
		// model.addAttribute("ciudades", listCiudades);

		return "/views/users/frmEditar";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idUsers, RedirectAttributes attribute) {

		Users users = null;

		if (idUsers > 0) {
			users = usersService.buscarPorId(idUsers);

			if (users == null) {
				System.out.println("Error: El ID del users no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del users no existe!");
				return "redirect:/views/users/";
			}
		} else {
			System.out.println("Error: Error con el ID del Users");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Userw!");
			return "redirect:/views/users/";
		}

		usersService.eliminar(idUsers);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/users/";
	}

}
