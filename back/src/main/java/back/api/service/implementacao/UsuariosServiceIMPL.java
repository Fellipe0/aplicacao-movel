package back.api.service.implementacao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.api.model.Usuarios;
import back.api.persistencia.hql.GenericDAO;
import back.api.persistencia.jpa.UsuariosDAO;
import back.api.service.UsuariosService;
import lombok.Getter;

@Getter
@Service
public class UsuariosServiceIMPL implements UsuariosService {

	private static final Log logger = LogFactory.getLog(UsuariosService.class);

	@Override
	public Log getLogger() {
		return logger;
	}

	@Autowired
	private GenericDAO genericDAO;

	@Autowired
	private UsuariosDAO persistencia;
	
	@Override
	public Usuarios save(Usuarios objeto) throws Exception {
		if(objeto.getId() == null) {
			if(!objeto.getPassword().equals(objeto.getConfirmedPassword())) {
				throw new Exception("Erro, senhas divergem");
			}
		}
		objeto.setId(findAll().size());
		return UsuariosService.super.save(objeto);
	}

	@Override
	public Usuarios findToLogin(String email, String senha) {
		return persistencia.findToLogin(email,senha);
	}

}
