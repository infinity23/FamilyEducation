package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import dao.EvaluationDao;
import domain.Evaluation;
import exception.DaoException;
import utils.BeanHandler;
import utils.JdbcUtils;

public class EvaluationDaoImpl implements EvaluationDao {
	
	/* (non-Javadoc)
	 * @see dao.impl.EvaluationDao#add(domain.Evaluation)
	 */
	@Override
	public void add(Evaluation a){
		String sql = "insert into evaluation(id,subject,description,stu_name,tch_id) values(?,?,?,?,?)";
		Object params[] = {a.getId(), a.getSubject(),a.getDescription(),a.getStu_name(),a.getTch_id()};
		try {
			JdbcUtils.update(sql, params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}


	/* (non-Javadoc)
	 * @see dao.impl.EvaluationDao#update(domain.Evaluation)
	 */
	@Override
	public void update(Evaluation a){
		String sql = "update evaluation set subject=?,description=?,stu_name=?,tch_id=? where id=?";
		Object params[] = {a.getSubject(),a.getDescription(),a.getStu_name(),a.getTch_id(),a.getId()};
		try {
			JdbcUtils.update(sql, params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	


	/* (non-Javadoc)
	 * @see dao.impl.EvaluationDao#delete(java.lang.String)
	 */
	@Override
	public void delete(String id){
		String sql = "delete from evaluation where id=?";
		Object params[] = {id};
		try {
			JdbcUtils.update(sql, params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	

	/* (non-Javadoc)
	 * @see dao.impl.EvaluationDao#find(java.lang.String)
	 */
	@Override
	public Evaluation find(String id){
		String sql = "select * from evaluation where id=?";
		Object params[] = {id};
		try {
			return (Evaluation)JdbcUtils.query(sql, params,  new BeanHandler(Evaluation.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	
	}

	
	/* (non-Javadoc)
	 * @see dao.impl.EvaluationDao#findAll(java.lang.String)
	 */
	@Override
	public HashMap<String, Evaluation> findAll(String tch_id){
		HashMap<String, Evaluation> map = new HashMap<>();
		try {
			Connection conn = JdbcUtils.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM evaluation where tch_id='"+tch_id+"';");
			while(rs.next()){
				Evaluation evaluation = new Evaluation();
				evaluation.setId(rs.getString("id"));
				evaluation.setSubject(rs.getString("subject"));
				evaluation.setDescription(rs.getString("description"));
				evaluation.setStu_name(rs.getString("stu_name"));
				evaluation.setTch_id(rs.getString("tch_id"));
				map.put(evaluation.getId(), evaluation);
			}
			JdbcUtils.release(conn, st, rs);
			return map;
			
		} catch (SQLException e) {
			e.printStackTrace();
			 throw new DaoException(e);
		}
		
	}
	
}
