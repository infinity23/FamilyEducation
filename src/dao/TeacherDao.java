package dao;

import java.util.HashMap;

import domain.Teacher;

public interface TeacherDao {

	/* (non-Javadoc)
	 * @see dao.impl.TeacherDao#add(domain.Teacher)
	 */
	void add(Teacher c);

	/* (non-Javadoc)
	 * @see dao.impl.TeacherDao#update(domain.Teacher)
	 */
	void update(Teacher c);

	/* (non-Javadoc)
	 * @see dao.impl.TeacherDao#delete(java.lang.String)
	 */
	void delete(String name);

	/* (non-Javadoc)
	 * @see dao.impl.TeacherDao#find(java.lang.String)
	 */
	Teacher findByName(String name);
	
	Teacher findByID(String id);

	HashMap<String, Teacher> all();

}