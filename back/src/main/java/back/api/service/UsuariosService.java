package back.api.service;

import org.springframework.stereotype.Component;

import back.api.model.Usuarios;
import back.api.util.CRUDPadraoService;

@Component
public interface UsuariosService extends CRUDPadraoService<Usuarios> {

	Usuarios findToLogin(String email, String senha);

}
