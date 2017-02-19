package utils;

import dao.impl.AdminDaoImpl;
import dao.impl.StudentDaoImpl;
import dao.impl.TeacherDaoImpl;
import domain.Admin;
import domain.Student;
import domain.Teacher;

public class ServiceUtils {
	public static Object getDaoImpl(Object user){
		if(user instanceof Student){
			return new StudentDaoImpl();
		}else if(user instanceof Teacher){
			return new TeacherDaoImpl();
		}else if(user instanceof Admin){
			return new AdminDaoImpl();
		}else {
			return null;
		}	
	}

}
