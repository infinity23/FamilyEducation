package dao.impl;

import java.util.HashMap;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.TeacherDao;
import domain.Teacher;
import exception.DaoException;
import utils.BeanHandler;
import utils.JdbcUtils;

public class TeacherDaoImpl implements TeacherDao {
	/* (non-Javadoc)
	 * @see dao.impl.TeacherDao#add(domain.Teacher)
	 */
	@Override
	public void add(Teacher c){
		try{
			String sql = "insert into teacher(id,name,passwd,gender,subject,email,telephone,description) values(?,?,?,?,?,?,?,?)";
			Object params[] = {c.getId(),c.getName(),c.getPasswd(),c.getGender(),c.getSubject(),c.getEmail(),c.getTelephone(),c.getDescription()};
			JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	

	/* (non-Javadoc)
	 * @see dao.impl.TeacherDao#update(domain.Teacher)
	 */
	@Override
	public void update(Teacher c){
		try{
		String sql = "update teacher set name=?,passwd=?,gender=?,subject=?,email=?,telephone=?,description=? where id=?";
		Object params[] = {c.getName(),c.getPasswd(),c.getGender(),c.getSubject(),c.getEmail(),c.getTelephone(),c.getDescription(),c.getId()};
		JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see dao.impl.TeacherDao#delete(java.lang.String)
	 */
	@Override
	public void delete(String name){
		try{
			String sql = "delete from teacher where name=?";
			Object params[] ={name};
			JdbcUtils.update(sql, params); 
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	

	/* (non-Javadoc)
	 * @see dao.impl.TeacherDao#find(java.lang.String)
	 */
	@Override
	public Teacher findByName(String name){
		
		try{
			String sql = "select * from teacher where name=?";
			Object params[] ={name};
			return (Teacher) JdbcUtils.query(sql, params, new BeanHandler(Teacher.class));
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	public Teacher findByID(String id){
		
		try{
			String sql = "select * from teacher where id=?";
			Object params[] ={id};
			return (Teacher) JdbcUtils.query(sql, params, new BeanHandler(Teacher.class));
		}catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.TeacherDao#all()
	 */
	@Override
	public HashMap<String, Teacher> all(){
		HashMap<String, Teacher> map = new HashMap<>();
		try {
			Connection conn = JdbcUtils.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM teacher;");
			while(rs.next()){
				Teacher teacher = new Teacher();
				teacher.setId(rs.getString("id"));
				teacher.setName(rs.getString("name"));
				teacher.setPasswd(rs.getString("passwd"));
				teacher.setGender(rs.getString("gender"));
				teacher.setEmail(rs.getString("email"));
				teacher.setTelephone(rs.getInt("telephone"));
				teacher.setSubject(rs.getString("subject"));
				teacher.setDescription(rs.getString("description"));
				map.put(teacher.getId(), teacher);
			}
			JdbcUtils.release(conn, st, rs);
			return map;
			
		} catch (SQLException e) {
			e.printStackTrace();
			 throw new DaoException(e);
		}
		
	}
	
	


}
