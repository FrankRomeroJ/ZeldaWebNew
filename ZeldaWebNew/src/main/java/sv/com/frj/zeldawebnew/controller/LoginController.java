package sv.com.frj.zeldawebnew.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(required = false) String error,
            @RequestParam(required = false) String logout,
			Model model, Principal principal, RedirectAttributes attribute) {				
		
		
		
		if(error!=null) {
			model.addAttribute("error", "ERROR DE ACCESO: Usuario y/o Contraseña son incorrectos");
		}
		
		if(principal!=null) {
			attribute.addFlashAttribute("warning", "ATENCION:  Ud ya ha iniciado sesión previamente");
			return "redirect:/index";
		}
		
		if(logout!=null) {
			model.addAttribute("success", "ATENCION: Ha finalizado sesión con éxito");
		}
		
		return "login";
	}	
}
