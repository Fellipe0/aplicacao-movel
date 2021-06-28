package back.api.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import back.api.model.Usuarios;

public interface UsuariosDAO extends JpaRepository<Usuarios, Long> {

	@Query(value = "select * from usuarios where email like :email and password like :senha and status = 'ATIVO'", nativeQuery = true)
	Usuarios findToLogin(@Param("email") String email, @Param("senha") String senha);

}
