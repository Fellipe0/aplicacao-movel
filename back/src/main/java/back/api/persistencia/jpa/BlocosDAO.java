package back.api.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import back.api.model.Blocos;

public interface BlocosDAO extends JpaRepository<Blocos, Long> {

}
