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

import sv.com.frj.zeldawebnew.models.entity.Acc_Tipopartida;
import sv.com.frj.zeldawebnew.models.entity.Ciudad;
import sv.com.frj.zeldawebnew.models.entity.Cliente;
import sv.com.frj.zeldawebnew.models.service.IAcc_TipopartidaService;
import sv.com.frj.zeldawebnew.models.service.ICiudadService;
import sv.com.frj.zeldawebnew.models.service.IClienteService;

@Controller
@RequestMapping("/views/acc/tipo")
public class Acc_TipopartidaController {

	@Autowired
	private IAcc_TipopartidaService acc_tipopartidaService;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/")
	public String listarAcc_Tipopartida(Model model) {
		List<Acc_Tipopartida> listadoAcc_Tipopartida = acc_tipopartidaService.listarTodos();
		model.addAttribute("titulo", "Lista de Tipo de Partidas");
		model.addAttribute("tipopartida", listadoAcc_Tipopartida);

		return "/views/acc/tipo/listar";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/create")
	public String crear(Model model) {

		Acc_Tipopartida tipopartida = new Acc_Tipopartida();

		model.addAttribute("titulo", "Formulario: Nuevo Tipo Partida");
		model.addAttribute("tipopartida", tipopartida);

		return "/views/acc/tipo/frmCrear";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Acc_Tipopartida tipopartida, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Tipo de Partida");
			model.addAttribute("tipopartida", tipopartida);
			System.out.println("Existieron errores en el formulario");
			return "/views/acc/tipo/frmCrear";
		}

		

		acc_tipopartidaService.guardar(tipopartida);
		
		System.out.println("Tipo de partida guardado con exito!");
		attribute.addFlashAttribute("success", "Tipo de Partida guardado con exito!");
		return "redirect:/views/acc/tipo/";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/edit/{codigo}")
	public String editar(@PathVariable("codigo") String codigo, Model model, RedirectAttributes attribute) {

		Acc_Tipopartida tipopartida = null;

		if (codigo != "  ") {
			tipopartida = acc_tipopartidaService.buscarPorId(codigo);

			if (codigo == null) {
				System.out.println("Error: El ID del tipo de partida no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El codigo del tipo de partida no existe!");
				return "redirect:/views/acc/tipo/";
			}
		} else {
			System.out.println("Error: Error con el codigo del Tipo de Partida");
			attribute.addFlashAttribute("error", "ATENCION: Error con el codigo del tipo de partida");
			return "redirect:/views/acc/tipo/";
		}

		model.addAttribute("titulo", "Formulario: Editar Tipo de Partida");
		model.addAttribute("tipopartida", tipopartida);

		return "/views/acc/tipo/frmEditar";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/delete/{codigo}")
	public String eliminar(@PathVariable("codigo") String codigo, RedirectAttributes attribute) {

		Acc_Tipopartida tipopartida = null;

		if (codigo != "  ") {
			tipopartida = acc_tipopartidaService.buscarPorId(codigo);

			if (tipopartida == null) {
				System.out.println("Error: El ID del tipo de partida no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El codigo del tipo de partida no existe!");
				return "redirect:/views/acc/tipo/";
			}
		} else {
			System.out.println("Error: Error con el codigo del tipo de partida");
			attribute.addFlashAttribute("error", "ATENCION: Error con el codigo del tipo de partida!");
			return "redirect:/views/acc/tipo/";
		}

		acc_tipopartidaService.eliminar(codigo);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/acc/tipo/";
	}

}
