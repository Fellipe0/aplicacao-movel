package back.api.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import back.api.controller.abstracts.ManterControllerBeanBasic;
import back.api.model.Usuarios;
import back.api.model.response.Response;
import back.api.service.UsuariosService;
import lombok.Getter;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController extends ManterControllerBeanBasic<Usuarios> {

	@Getter
	@Autowired
	private UsuariosService service;

	@GetMapping(value = "/login")
	public ResponseEntity<Response<Usuarios>> login(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("senha") String senha) {
		Response<Usuarios> response = new Response<>();
		ArrayList<String> arrayErros = new ArrayList<>();
		try {
			response.setData(service.findToLogin(email, senha));
		} catch (Exception e) {
			arrayErros.add(e.getMessage());
			response.setErros(arrayErros);
		}
		return ResponseEntity.ok(response);
	}

}
