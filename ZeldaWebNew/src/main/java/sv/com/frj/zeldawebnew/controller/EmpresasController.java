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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.com.frj.zeldawebnew.models.entity.Departamentos;
import sv.com.frj.zeldawebnew.models.entity.Empresas;
import sv.com.frj.zeldawebnew.models.entity.Paises;
import sv.com.frj.zeldawebnew.models.entity.Municipios;
import sv.com.frj.zeldawebnew.models.service.IDepartamentosService;
import sv.com.frj.zeldawebnew.models.service.IEmpresasService;
import sv.com.frj.zeldawebnew.models.service.IMunicipiosService;
import sv.com.frj.zeldawebnew.models.service.IPaisesService;

@Controller
@RequestMapping("/views/empresas")
public class EmpresasController {
	
	@Autowired
	private IEmpresasService empresasService;
	
	@Autowired
	private IPaisesService paisesService;

	@Autowired
	private IDepartamentosService departamentosService;
	
	@Autowired
	private IMunicipiosService municipiosService;

	Integer idPaises = 0;
	Integer idDepartamentos = 0;
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/")
	public String listarEmpresas(Model model) {
		List<Empresas> empresas =  empresasService.listarTodos();
	//	List<Departamentos> listadoDepartamentos = departamentosService.buscarPorIdpais(idpais);
	//	List<Municipios> listadoMunicipios = municipiosService.buscarPorReg_depto(reg_depto);
		model.addAttribute("titulo", "Lista de Empresas");
		model.addAttribute("empresas", empresas);
	//	model.addAttribute("departamentos", listadoDepartamentos);
	//	model.addAttribute("municipios", listadoMunicipios);

		return "/views/empresas/listar";
	}

	@ModelAttribute("paises")
	public List<Paises> getPaises(){
		return paisesService.listarPaisesActivos();
	}
	
	@GetMapping(value = "/buscarPorPais")
	public @ResponseBody List<Departamentos> todosDepartamentosPorPais(
			@RequestParam(value = "idPaises", required = true) Integer idPaises) {

		return departamentosService.buscarPorIdPaises(idPaises);
	}

		@GetMapping(value = "/buscarPorDepartamento")
		public @ResponseBody List<Municipios> todosMunicipiosPorDepartamento(
				@RequestParam(value = "idDepartamentos", required = true) Integer idDepartamentos) {

			return municipiosService.buscarPorIdDepartamentos(idDepartamentos);
		}
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/create")
	public String crear(Model model) {

		Empresas empresas = new Empresas();
		List<Departamentos> listaDepartamentos = departamentosService.buscarPorIdPaises(idPaises);
		List<Municipios> listaMunicipios = municipiosService.buscarPorIdDepartamentos(idDepartamentos);
		model.addAttribute("titulo", "Lista de Empresas");
		model.addAttribute("empresas", empresas);
		model.addAttribute("departamentos", listaDepartamentos);
		model.addAttribute("municipios", listaMunicipios);


		return "/views/empresas/frmCrear";
	}

	@Secured({ "ROLE_ADMIN" , "ROLE_USER" })
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Empresas empresas, 
			BindingResult result,
			Model model, RedirectAttributes attribute) {
		
		List<Departamentos> listadoDepartamentos = departamentosService.buscarPorIdPaises(idPaises);
		List<Municipios> listadoMunicipios = municipiosService.buscarPorIdDepartamentos(idDepartamentos);
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Cliente");
			model.addAttribute("empresas", empresas);
			model.addAttribute("departamentos", listadoDepartamentos);
			model.addAttribute("municipios", listadoMunicipios);
			System.out.println("Existieron errores en el formulario");			
			return "/views/empresas/frmCrear";
		}

		empresasService.guardar(empresas);
		System.out.println("Cliente guardado con exito!");
		attribute.addFlashAttribute("success", "Cliente guardado con exito!");
		return "redirect:/views/empresas/";
	}

	@Secured({ "ROLE_ADMIN" , "ROLE_USER" })
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {
			
		Empresas empresa = null;
		
		if (id > 0) {
			empresa = empresasService.buscarPorId(id);
			
			if (empresa == null) {
				System.out.println("Error: El ID de la empresa no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID de la empresa no existe!");
				return "redirect:/views/empresas/";
			}
		}else {
			System.out.println("Error: Error con el ID de la empresa");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID de la empresa");
			return "redirect:/views/empresas/";
		}
		
		List<Departamentos> listadoDepartamentos = departamentosService.buscarPorIdPaises(idPaises);
		List<Municipios> listadoMunicipios = municipiosService.buscarPorIdDepartamentos(idDepartamentos);

		model.addAttribute("titulo", "Formulario: Editar Cliente");
		model.addAttribute("empresa", empresa);
		model.addAttribute("departamentos", listadoDepartamentos);
		model.addAttribute("municipios", listadoMunicipios);
		
		return "/views/empresas/frmCrear";
	}

	@Secured({ "ROLE_ADMIN" , "ROLE_USER" })
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer id, RedirectAttributes attribute) {

		Empresas empresa = null;
		
		if (id > 0) {
			empresa = empresasService.buscarPorId(id);
			
			if (empresa == null) {
				System.out.println("Error: El ID de la empresa no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID de la empresa no existe!");
				return "redirect:/views/empresas/";
			}
		}else {
			System.out.println("Error: Error con el ID de la empresa");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID de la empresa!");
			return "redirect:/views/empresas/";
		}		
		
		empresasService.eliminar(id);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/empresas/";
	}

}
