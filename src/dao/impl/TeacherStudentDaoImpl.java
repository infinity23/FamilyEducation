package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import dao.TeacherDao;
import dao.TeacherStudentDao;
import domain.Info;
import exception.DaoException;
import utils.BeanHandler;
import utils.JdbcUtils;

public class TeacherStudentDaoImpl implements TeacherStudentDao {
	/* (non-Javadoc)
	 * @see dao.impl.TeacherStudentDao#add(domain.Info)
	 */
	@Override
	public void add(Info c){
		try{
			
			String sql = "insert into Info(id,title,subject,description,state,stu_id,tch_id,eva_state) values(?,?,?,?,?,?,?,?)";
			Object params[] = {c.getId(),c.getTitle(),c.getSubject(),c.getDescription(),c.getState(),c.getStu_id(),c.getTch_id(),c.getEva_state()};
			JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.TeacherStudentDao#update(domain.Info)
	 */
	@Override
	public void update(Info c){
		try{
			String sql = "update Info set title=?,subject=?,description=?,state=?,stu_id=?,tch_id=?,eva_state=? where id=?";
			Object params[] = {c.getTitle(),c.getSubject(),c.getDescription(),c.getState(),c.getStu_id(),c.getTch_id(),c.getEva_state(),c.getId()};
		JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.TeacherStudentDao#delete(java.lang.String)
	 */
	@Override
	public void delete(String id){
		try{
			String sql = "delete from Info where id=?";
			Object params[] ={id};
			JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.TeacherStudentDao#find(java.lang.String)
	 */
	@Override
	public Info find(String id){
		
		try{
			String sql = "select * from Info where id=?";
			Object params[] ={id};
			return (Info) JdbcUtils.query(sql, params, new BeanHandler(Info.class));
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}

	/* (non-Javadoc)
	 * @see dao.impl.TeacherStudentDao#findByStuID(java.lang.String)
	 */
	@Override
	public HashMap<String, Info> findByStuID(String id){
		TeacherDao dao = new TeacherDaoImpl();
		HashMap<String, Info> map = new HashMap<>();
		try {
			Connection conn = JdbcUtils.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM info where stu_id='"+id+"';");
			while(rs.next()){
				Info info = new Info();
				info.setId(rs.getString("id"));
				info.setTitle(rs.getString("title"));
				info.setSubject(rs.getString("subject"));
				info.setDescription(rs.getString("description"));
				info.setStu_id(rs.getString("stu_id"));
				info.setTch_id(rs.getString("tch_id"));
				info.setState(rs.getString("state"));
				info.setEva_state(rs.getString("eva_state"));
				map.put(dao.findByID(info.getTch_id()).getName(), info);
			}
			JdbcUtils.release(conn, st, rs);
			return map;
			
		} catch (SQLException e) {
			e.printStackTrace();
			 throw new DaoException(e);
		}
	}

	/* (non-Javadoc)
	 * @see dao.impl.TeacherStudentDao#findByTchID(java.lang.String)
	 */
	@Override
	public HashMap<String, Info> findByTchID(String id){
		HashMap<String, Info> map = new HashMap<>();
		try {
			Connection conn = JdbcUtils.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM info where tch_id='"+id+"';");
			while(rs.next()){
				Info info = new Info();
				info.setId(rs.getString("id"));
				info.setTitle(rs.getString("title"));
				info.setSubject(rs.getString("subject"));
				info.setDescription(rs.getString("description"));
				info.setStu_id(rs.getString("stu_id"));
				info.setTch_id(rs.getString("tch_id"));
				info.setState(rs.getString("state"));
				info.setEva_state(rs.getString("eva_state"));
				map.put(info.getId(),info);
			}
			JdbcUtils.release(conn, st, rs);
			return map;
			
		} catch (SQLException e) {
			e.printStackTrace();
			 throw new DaoException(e);
		}
	}	
}
