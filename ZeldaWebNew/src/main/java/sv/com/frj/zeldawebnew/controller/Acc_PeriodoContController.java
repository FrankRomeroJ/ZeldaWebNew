package sv.com.frj.zeldawebnew.controller;

import java.time.LocalDate;
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

import sv.com.frj.zeldawebnew.models.entity.Acc_PeriodoCont;
import sv.com.frj.zeldawebnew.models.entity.Acc_PeriodoContPK;
import sv.com.frj.zeldawebnew.models.entity.Acc_Tipopartida;
import sv.com.frj.zeldawebnew.models.service.IAcc_PeriodoContService;

@Controller
@RequestMapping("/views/acc/periodo")
public class Acc_PeriodoContController {

	@Autowired
	private IAcc_PeriodoContService acc_PeriodoContService;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/")
	public String listarAcc_PeriodoCont(Model model) {
		List<Acc_PeriodoCont> listadoAcc_PeriodoCont = acc_PeriodoContService.listarTodosDesc();
		
	
		model.addAttribute("titulo", "Lista de Periodos Contables");
		model.addAttribute("periodocont", listadoAcc_PeriodoCont);

		return "/views/acc/periodo/listar";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/create")
	public String crear(Model model) {

		Acc_PeriodoCont periodocont = new Acc_PeriodoCont();

		model.addAttribute("titulo", "Formulario: Nuevo Periodo Contable");
		model.addAttribute("periodocont", periodocont);

		return "/views/acc/periodo/frmCrear";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Acc_PeriodoCont periodocont, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Tipo de Partida");
			model.addAttribute("periodocont", periodocont);
			System.out.println("Existieron errores en el formulario");
			return "/views/acc/periodo/frmCrear";
		}

		acc_PeriodoContService.guardar(periodocont);
		
		System.out.println("Periodo Contable guardado con exito!");
		attribute.addFlashAttribute("success", "Periodo Contable guardado con exito!");
		return "redirect:/views/acc/periodo/";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/edit/{llave}")
	public String editar(@PathVariable("llave") Acc_PeriodoContPK llave, Model model, RedirectAttributes attribute) {

		Acc_PeriodoCont periodocont = null;

		periodocont = acc_PeriodoContService.buscarPorId(llave);
		model.addAttribute("titulo", "Formulario: Editar Periodo Contable");
		model.addAttribute("peridocont", periodocont);

		return "/views/acc/periodo/frmEditar";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/delete/{llave}")
	public String eliminar(@PathVariable("llave") Acc_PeriodoContPK llave, RedirectAttributes attribute) {

		Acc_PeriodoCont periodocont = null;

		periodocont = acc_PeriodoContService.buscarPorId(llave);
		
		if (periodocont != null) {

			acc_PeriodoContService.eliminar(llave);
			System.out.println("Registro Eliminado con Exito!");
			attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		
		} else {
			System.out.println("Error: El ID del tipo de partida no existe!");
			attribute.addFlashAttribute("error", "ATENCION: El codigo del tipo de partida no existe!");
			
		}
		
		return "redirect:/views/acc/periodo/";
	}

}
