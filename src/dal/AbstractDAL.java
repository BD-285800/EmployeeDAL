package dal;

import java.util.List;

import domain.AbstractEntity;

public interface AbstractDAL <T extends AbstractEntity> {
	List<T> getAll();
	T getById(int id);
	void insert(T entity);
	void update(T entity);
	void delete(int id);
}
