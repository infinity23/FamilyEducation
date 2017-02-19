package dao.impl;

import java.sql.SQLException;

import dao.AdminDao;
import domain.Admin;
import exception.DaoException;
import utils.BeanHandler;
import utils.JdbcUtils;

public class AdminDaoImpl implements AdminDao {

	/* (non-Javadoc)
	 * @see dao.impl.AdminDao#add(domain.Admin)
	 */
	@Override
	public void add(Admin a){
		String sql = "insert into admin(id,name,passwd) values(?,?,?)";
		Object params[] = {a.getId(), a.getName(),a.getPasswd()};
		try {
			JdbcUtils.update(sql, params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}


	/* (non-Javadoc)
	 * @see dao.impl.AdminDao#update(domain.Admin)
	 */
	@Override
	public void update(Admin a){
		String sql = "update admin set name=?,passwd=? where id=?";
		Object params[] = { a.getName(),a.getPasswd(),a.getId()};
		try {
			JdbcUtils.update(sql, params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	


	/* (non-Javadoc)
	 * @see dao.impl.AdminDao#delete(java.lang.String)
	 */
	@Override
	public void delete(String name){
		String sql = "delete from admin where name=?";
		Object params[] = {name};
		try {
			JdbcUtils.update(sql, params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	

	/* (non-Javadoc)
	 * @see dao.impl.AdminDao#find(java.lang.String)
	 */
	@Override
	public Admin find(String name){
		String sql = "select * from admin where name=?";
		Object params[] = {name};
		try {
			return (Admin)JdbcUtils.query(sql, params,  new BeanHandler(Admin.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	
	}
	
	
}
