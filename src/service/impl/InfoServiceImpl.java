package service.impl;

import java.util.HashMap;

import dao.TeacherStudentDao;
import dao.impl.TeacherStudentDaoImpl;
import domain.Info;
import service.InfoService;

public class InfoServiceImpl implements InfoService {
	private TeacherStudentDao infoDao = new TeacherStudentDaoImpl();

	/* (non-Javadoc)
	 * @see service.impl.InfoService#add(domain.Info)
	 */
	@Override
	public void add(Info info){
		infoDao.add(info);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.InfoService#delete(java.lang.String)
	 */
	@Override
	public void delete(String id){
		infoDao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.InfoService#update(domain.Info)
	 */
	@Override
	public void update(Info info){
		infoDao.update(info);
	}
	
	
	/* (non-Javadoc)
	 * @see service.impl.InfoService#find(java.lang.String)
	 */
	@Override
	public Info find(String id){
		return new TeacherStudentDaoImpl().find(id);
		
	}
	
	/* (non-Javadoc)
	 * @see service.impl.InfoService#findByStuID(java.lang.String)
	 */
	@Override
	public HashMap<String, Info> findByStuID(String id){
		return new TeacherStudentDaoImpl().findByStuID(id);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.InfoService#findByTchID(java.lang.String)
	 */
	@Override
	public HashMap<String, Info> findByTchID(String id){
		return new TeacherStudentDaoImpl().findByTchID(id);
	}
	
	
}
