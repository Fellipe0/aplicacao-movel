package back.api.model.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ICrudPadraoService<T>{
	List<T> findAll();

	T findById(Object id);

	T save(T objeto) throws Exception;

	Boolean existsByField(String fieldName, Object value) throws Exception;

	T findByField(String field, Object value);

	Page<T> paginarComParemetros(Integer page, Integer count);

	Boolean deleteById(String id);
}
