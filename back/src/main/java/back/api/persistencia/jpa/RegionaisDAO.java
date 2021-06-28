package back.api.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import back.api.model.Regionais;

public interface RegionaisDAO extends JpaRepository<Regionais, Long> {

}
