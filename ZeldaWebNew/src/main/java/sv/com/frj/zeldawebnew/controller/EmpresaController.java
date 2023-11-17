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
import sv.com.frj.zeldawebnew.models.entity.Departamento;
import sv.com.frj.zeldawebnew.models.entity.Empresa;
import sv.com.frj.zeldawebnew.models.entity.Pais;
import sv.com.frj.zeldawebnew.models.entity.Municipio;
import sv.com.frj.zeldawebnew.models.service.IDepartamentoService;
import sv.com.frj.zeldawebnew.models.service.IEmpresaService;
import sv.com.frj.zeldawebnew.models.service.IMunicipioService;
import sv.com.frj.zeldawebnew.models.service.IPaisService;

@Controller
@RequestMapping("/views/empresa")
public class EmpresaController {

	@Autowired
	private IEmpresaService empresaService;

	@Autowired
	private IPaisService paisService;

	@Autowired
	private IDepartamentoService departamentoService;

	@Autowired
	private IMunicipioService municipioService;

	Integer idPais = 0;
	Integer idDepartamento = 0;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/")
	public String listarEmpresas(Model model) {
		List<Empresa> empresa = empresaService.listarTodos();
		model.addAttribute("titulo", "Lista de Empresas");
		model.addAttribute("empresa", empresa);

		return "/views/empresa/listar";
	}

	@ModelAttribute("paises")
	public List<Pais> getPaises() {

		return paisService.listarPaisesActivos();
	}

	@GetMapping(value = "/buscarPorPais")
	public @ResponseBody List<Departamento> todosDepartamentoPorPais(
			@RequestParam(value = "idPais", required = true) Integer idPais) {

		return departamentoService.buscarPorIdPais(idPais);
	}

	@GetMapping(value = "/buscarPorDepartamento")
	public @ResponseBody List<Municipio> todosMunicipioPorDepartamento(
			@RequestParam(value = "idDepartamento", required = true) Integer idDepartamento) {

		return municipioService.buscarPorIdDepartamento(idDepartamento);
	}
	
	@GetMapping(value = "/buscarPorMunicipio")
	public @ResponseBody Municipio MunicipioPorId(
			@RequestParam(value = "idMunicipio", required = true) Integer idMunicipio) {

		return municipioService.buscarPorId(idMunicipio);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/consultar/{id}")
	public String consultar(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {

		Empresa empresa = empresaService.buscarPorId(id);	
		
		model.addAttribute("titulo", "Formulario: Consulta de Empresa");
		model.addAttribute("empresa", empresa);
		// model.addAttribute("pais",listaPais);
		

		return "/views/empresa/frmConsultar";
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/create")
	public String crear(Model model) {

		Empresa empresa = new Empresa();
		// List<Pais> listaPais = paisService.listarPaisesActivos();
		List<Departamento> listaDepartamento = departamentoService.buscarPorIdPais(idPais);
		List<Municipio> listaMunicipio = municipioService.buscarPorIdDepartamento(idDepartamento);
		model.addAttribute("titulo", "Lista de Empresas");
		model.addAttribute("empresa", empresa);
		// model.addAttribute("pais",listaPais);
		model.addAttribute("departamento", listaDepartamento);
		model.addAttribute("municipio", listaMunicipio);

		return "/views/empresa/frmCrear";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Empresa empresa, 
			@Valid @RequestParam("pais") Pais pais, 
			@Valid @RequestParam("departamento") Departamento departamento, 
			@Valid @RequestParam("municipio") Municipio municipio, 
						BindingResult result, Model model,
			RedirectAttributes attribute) {
		Integer mipais =pais.getId();
		Integer midepartamento=departamento.getId();
		Integer mimunicipio = municipio.getId();
		empresa.setPais(paisService.buscarPorId(mipais));
	    empresa.setDepartamento(departamentoService.buscarPorId(midepartamento)) ;
		empresa.setMunicipio(municipioService.buscarPorId(mimunicipio));

		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Cliente");
			model.addAttribute("empresa", empresa);
			System.out.println("Existieron errores en el formulario");
			return "/views/empresa/frmCrear";
		}
	
		empresaService.guardar(empresa);
		System.out.println("Empresa guardada con exito!");
		attribute.addFlashAttribute("success", "Empresa guardado con exito!");
		return "redirect:/views/empresa/";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {

		Empresa empresa = null;

		if (id > 0) {
			empresa = empresaService.buscarPorId(id);

			if (empresa == null) {
				System.out.println("Error: El ID de la empresa no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID de la empresa no existe!");
				return "redirect:/views/empresa/";
			}
		} else {
			System.out.println("Error: Error con el ID de la empresa");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID de la empresa");
			return "redirect:/views/empresa/";
		}
		
		
		List<Departamento> listadoDepartamento = departamentoService.buscarPorIdPais(empresa.getPais().getId());
		List<Municipio> listadoMunicipio = municipioService.buscarPorIdDepartamento(idDepartamento);

		model.addAttribute("titulo", "Formulario: Editar Empresa");
		model.addAttribute("empresa", empresa);
		// model.addAttribute("pais",listaPais);
		model.addAttribute("departamento", listadoDepartamento);
		model.addAttribute("municipio", listadoMunicipio);

		return "/views/empresa/frmEditar";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer id, RedirectAttributes attribute) {

		Empresa empresa = null;

		if (id > 0) {
			empresa = empresaService.buscarPorId(id);

			if (empresa == null) {
				System.out.println("Error: El ID de la empresa no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID de la empresa no existe!");
				return "redirect:/views/empresa/";
			}
		} else {
			System.out.println("Error: Error con el ID de la empresa");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID de la empresa!");
			return "redirect:/views/empresa/";
		}

		empresaService.eliminar(id);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/empresa/";
	}

}
