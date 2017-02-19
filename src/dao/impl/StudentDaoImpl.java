package dao.impl;

import dao.StudentDao;
import domain.Student;
import exception.DaoException;
import utils.BeanHandler;
import utils.JdbcUtils;

public class StudentDaoImpl implements StudentDao {
	/* (non-Javadoc)
	 * @see dao.impl.StudentDao#add(domain.Student)
	 */
	@Override
	public void add(Student c){
		try{
			String sql = "insert into student(id,name,passwd,gender,email,telephone,description) values(?,?,?,?,?,?,?)";
			Object params[] = {c.getId(),c.getName(),c.getPasswd(),c.getGender(),c.getEmail(),c.getTelephone(),c.getDescription()};
			JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.StudentDao#update(domain.Student)
	 */
	@Override
	public void update(Student c){
		try{
			String sql = "update student set name=?,passwd=?,gender=?,email=?,telephone=?,description=? where id=?";
			Object params[] = {c.getName(),c.getPasswd(),c.getGender(),c.getEmail(),c.getTelephone(),c.getDescription(),c.getId()};
		JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.StudentDao#delete(java.lang.String)
	 */
	@Override
	public void delete(String name){
		try{
			String sql = "delete from student where name=?";
			Object params[] ={name};
			JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.StudentDao#find(java.lang.String)
	 */
	@Override
	public Student find(String name){
		
		try{
			String sql = "select * from student where name=?";
			Object params[] ={name};
			return (Student) JdbcUtils.query(sql, params, new BeanHandler(Student.class));
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}



}
