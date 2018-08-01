package pe.com.optical.middleware.crm.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable>{
	
	T buscar(ID id);
	List<T> obtenerTodos();
	void crear(T object);
	void actualizar(T object);
	void eliminar(T object);
	default void eliminar(ID id) {
		eliminar(buscar(id));
	}

}
