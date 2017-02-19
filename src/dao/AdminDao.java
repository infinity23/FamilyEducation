package dao;

import domain.Admin;

public interface AdminDao {

	void add(Admin a);

	void update(Admin a);

	void delete(String name);

	Admin find(String name);

}