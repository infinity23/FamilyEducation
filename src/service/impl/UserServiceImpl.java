package service.impl;


import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.impl.AdminDaoImpl;
import dao.impl.StudentDaoImpl;
import dao.impl.TeacherDaoImpl;
import domain.Admin;
import domain.Student;
import domain.Teacher;
import exception.WrongUserType;
import service.UserService;

public class UserServiceImpl implements UserService {
	private StudentDao stuDao = new StudentDaoImpl();
	private TeacherDao tchDao = new TeacherDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();
 	
	/* (non-Javadoc)
	 * @see service.impl.UserService#addUser(T)
	 */
	@Override
	public <T> void addUser(T user) throws WrongUserType{
		if(user instanceof Student){
			stuDao.add((Student) user);
		}else if(user instanceof Teacher){
			tchDao.add((Teacher) user);
		}else if(user instanceof Admin){
			adminDao.add((Admin) user);
		}else {
			throw new WrongUserType("addUser wrong user type");
		}
	
	}
	
	/* (non-Javadoc)
	 * @see service.impl.UserService#findUser(T)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T findUser(T user){
		if(user instanceof Student){
			return (T) stuDao.find(((Student) user).getName());
		}else if(user instanceof Teacher){
			return (T) tchDao.findByName(((Teacher) user).getName());
		}else if(user instanceof Admin){
			return (T) adminDao.find(((Admin) user).getName());
		}else {
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see service.impl.UserService#deleteUser(T)
	 */
	@Override
	public <T> void deleteUser(T user) throws WrongUserType{
		if(user instanceof Student){
			stuDao.delete(((Student)user).getName());
		}else if(user instanceof Teacher){
			tchDao.delete(((Teacher)user).getName());
		}else if(user instanceof Admin){
			adminDao.delete(((Admin)user).getName());
		}else {
			throw new WrongUserType("deleteUser wrong user type");
		}
	}
	
	/* (non-Javadoc)
	 * @see service.impl.UserService#updateUser(T)
	 */
	@Override
	public <T> void updateUser(T user) throws WrongUserType{
		if(user instanceof Student){
			stuDao.update((Student)user);
		}else if(user instanceof Teacher){
			tchDao.update((Teacher)user);
		}else if(user instanceof Admin){
			adminDao.update((Admin)user);
		}else {
			throw new WrongUserType("updateUser wrong user type");
		}
	}

}
