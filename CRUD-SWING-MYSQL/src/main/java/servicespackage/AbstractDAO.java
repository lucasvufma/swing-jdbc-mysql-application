package servicespackage;

import java.util.List;

public interface AbstractDAO<T> {
	List<T> recupera();
	void atualiza(T obj);	
	void adiciona(T obj);
		
}

