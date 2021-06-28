package back.api.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import back.api.model.Unidades;

public interface UnidadesDAO extends JpaRepository<Unidades, Long> {

}
