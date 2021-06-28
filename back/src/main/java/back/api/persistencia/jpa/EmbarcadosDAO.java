package back.api.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import back.api.model.Embarcados;

public interface EmbarcadosDAO extends JpaRepository<Embarcados, Long> {

}
