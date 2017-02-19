package dao;

import domain.Student;

public interface StudentDao {

	void add(Student c);

	void update(Student c);

	void delete(String name);

	Student find(String name);

}