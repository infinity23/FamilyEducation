package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	
	private static String url = "jdbc:mysql://localhost:3306/education";
	private static String username = "root";
	private static String password = "root";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
		
	}

public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void release(Connection conn,Statement st,ResultSet rs){
		
		
		if(rs!=null){
			try{
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		if(st!=null){
			try{
				st.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
		public static void update(String sql,Object params[]) throws SQLException{
			Connection conn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			try{
				conn = getConnection();
				st = conn.prepareStatement(sql);
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
				st.executeUpdate();
				
			}finally{
				release(conn, st, rs);
			}
		}
		
		public static Object query(String sql,Object params[],ResultSetHandler rsh) throws SQLException{
			
			Connection conn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			try{
				conn = getConnection();
				st = conn.prepareStatement(sql);
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
				rs = st.executeQuery();
				return rsh.handler(rs);
				
			}finally{
				release(conn, st, rs);
			}
		}

}
