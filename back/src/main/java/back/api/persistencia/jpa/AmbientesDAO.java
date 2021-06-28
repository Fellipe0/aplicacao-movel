package back.api.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import back.api.model.Ambientes;

public interface AmbientesDAO extends JpaRepository<Ambientes, Long> {

}
