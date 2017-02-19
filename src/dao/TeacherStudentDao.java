package dao;

import java.util.HashMap;

import domain.Info;

public interface TeacherStudentDao {

	void add(Info c);

	void update(Info c);

	void delete(String id);

	Info find(String id);

	HashMap<String, Info> findByStuID(String id);

	HashMap<String, Info> findByTchID(String id);

}