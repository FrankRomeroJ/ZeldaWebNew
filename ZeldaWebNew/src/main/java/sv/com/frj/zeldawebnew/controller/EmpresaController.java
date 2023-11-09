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
		// List<Departamentos> listadoDepartamentos =
		// departamentosService.buscarPorIdpais(idpais);
		// List<Municipios> listadoMunicipios =
		// municipiosService.buscarPorReg_depto(reg_depto);
		model.addAttribute("titulo", "Lista de Empresas");
		model.addAttribute("empresa", empresa);
		// model.addAttribute("departamento", listadoDepartamento);
		// model.addAttribute("municipio", listadoMunicipio);

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
	public String guardar(@Valid @ModelAttribute Empresa empresa, BindingResult result, Model model,
			RedirectAttributes attribute) {
//		List<Pais> listaPais = paisService.listarPaisesActivos();
		List<Departamento> listadoDepartamento = departamentoService.buscarPorIdPais(idPais);
		List<Municipio> listadoMunicipio = municipioService.buscarPorIdDepartamento(idDepartamento);

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Cliente");
			model.addAttribute("empresa", empresa);
//			model.addAttribute("pais",listaPais);
			model.addAttribute("departamento", listadoDepartamento);
			model.addAttribute("municipio", listadoMunicipio);
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
		List<Pais> listaPais = paisService.listarPaisesActivos();
		List<Departamento> listadoDepartamento = departamentoService.buscarPorIdPais(idPais);
		List<Municipio> listadoMunicipio = municipioService.buscarPorIdDepartamento(idDepartamento);

		model.addAttribute("titulo", "Formulario: Editar Cliente");
		model.addAttribute("empresa", empresa);
		// model.addAttribute("pais",listaPais);
		model.addAttribute("departamento", listadoDepartamento);
		model.addAttribute("municipio", listadoMunicipio);

		return "/views/empresa/frmCrear";
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
