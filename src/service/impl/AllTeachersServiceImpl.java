package service.impl;

import java.util.HashMap;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import domain.Teacher;
import service.AllTeachersService;

public class AllTeachersServiceImpl implements AllTeachersService {
	/* (non-Javadoc)
	 * @see service.impl.AllTeachersService#AllTeachers()
	 */
	@Override
	public HashMap<String, Teacher> AllTeachers() {
		TeacherDao tchDao = new TeacherDaoImpl();
		return tchDao.all();
	}

}
