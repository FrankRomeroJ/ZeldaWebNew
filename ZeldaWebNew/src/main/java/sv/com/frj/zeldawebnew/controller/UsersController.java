package sv.com.frj.zeldawebnew.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.frj.zeldawebnew.models.entity.CambiaClaveUser;
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
	@GetMapping("/cambiaclaveUser")
	public String cambiaclave(

			Model model) {

		CambiaClaveUser nuevaclaveuser = new CambiaClaveUser();

		model.addAttribute("titulo", "Formulario: Cambio de Contraseña");
		model.addAttribute("nuevaclaveuser", nuevaclaveuser);

		return "/views/users/frmCambiarContrasenaUser";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/cambiaContrasenaUser")
	public String guardaClaveUser(@Valid @ModelAttribute CambiaClaveUser nuevaclaveuser, BindingResult result,
			Model model, RedirectAttributes attribute) {

		// CambiaClaveUser cambiaClaveUser = new CambiaClaveUser();

		String passold = null;
		String passnew = null;
		String passrep = null;
		String passcur = null;

		Users users = new Users();
		Users usersA = new Users();
		Users usersN = new Users();
		Users usersR = new Users();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		users.setUsername(auth.getName());

		users = (usersService.buscarPorUsername(auth.getName()));

		Long idUsers = users.getId();

		users = usersService.buscarPorId(idUsers);

		passcur = String.valueOf(users.getPassword());

		usersA = users;
		passold = nuevaclaveuser.getPasswordA();

		usersN = users;
		passnew = nuevaclaveuser.getPasswordN();

		usersR = users;

		passrep = nuevaclaveuser.getPasswordR();

		if (!encoder.matches(passold, users.getPassword())) {

			System.out.println("Error: El Password anterior no coinciide");
			attribute.addFlashAttribute("error", "ATENCION: El Password anterior no coincide!");
			return "redirect:/views/users/cambiaclaveUser";
		}

		if (String.valueOf(passnew) == null) {

			System.out.println("Error:  El Password nuevo no puede ser vacio");
			attribute.addFlashAttribute("error", "ATENCION: El Password nuevo no puede ser vacio!");
			return "redirect:/views/users/cambiaclaveUser";

		}

		if (String.valueOf(passnew).trim().equals(String.valueOf(" ").trim())) {

			System.out.println("Error:  El Password nuevo no puede ser vacio");
			attribute.addFlashAttribute("error", "ATENCION: El Password nuevo no puede ser vacio!");
			return "redirect:/views/users/cambiaclaveUser";

		}

		if (encoder.matches(passnew, users.getPassword())) {
			System.out.println("Error: El Password no puede ser igual a la anterior");
			attribute.addFlashAttribute("error", "ATENCION: El Password no puede ser igual a la anterior!");
			return "redirect:/views/users/cambiaclaveUser";

		}
		if (!(String.valueOf(String.valueOf(passnew)).equals(String.valueOf(String.valueOf(passrep))))) {

			System.out.println("Error: El Password nuevo no coincide");
			attribute.addFlashAttribute("error", "ATENCION: El Password nuevo no coincide!");
			return "redirect:/views/users/cambiaclaveUser";
		}

		users.setPassword(encoder.encode(passnew));

		usersService.guardar(users);

		model.addAttribute("titulo", "Formulario: Cambiar clave de usuario");
		model.addAttribute("users", users);
		// model.addAttribute("ciudades", listCiudades);

		System.out.println("Success: El Password fue Actualizado con exito");
		attribute.addFlashAttribute("success", "ATENCION: El password fue actualizada con exito");
		// return "redirect:/views/users/frmCambiarContrasenaUser";
		return "redirect:/index";
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/cambiaclaveadmin/{id}")
	public String cambiaclaveadmin(@PathVariable("id") Long idUsers, Model model, RedirectAttributes attribute) {

		Users users = new Users();

		users = usersService.buscarPorId(idUsers);

		users.setPassword(null);

		model.addAttribute("titulo", "Formulario: Cambio de Contraseña por Administrador");
		model.addAttribute("users", users);

		return "/views/users/frmCambiarContrasenaAdmin";
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/cambiaClaveAdmin")
	public String guardaClaveAdmin(
			@Valid @ModelAttribute Users users, 
			BindingResult result, 
			Model model,
			RedirectAttributes attribute) {
	
		users.setPassword(encoder.encode(users.getPassword()));
		
		usersService.buscarPorId(users.getId());

		model.addAttribute("titulo", "Formulario: Cambiar clave de usuario");
		model.addAttribute("users", users);

		usersService.guardar(users);

		System.out.println("Success: El Password fue Actualizado con exito");
		attribute.addFlashAttribute("success", "ATENCION: El password fue actualizada con exito");
		return "redirect:/index";
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
