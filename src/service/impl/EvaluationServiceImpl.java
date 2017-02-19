package service.impl;

import java.util.HashMap;


import dao.EvaluationDao;
import dao.impl.EvaluationDaoImpl;
import domain.Evaluation;
import service.EvaluationService;

public class EvaluationServiceImpl implements EvaluationService {
	EvaluationDao dao = new EvaluationDaoImpl();
	
	/* (non-Javadoc)
	 * @see service.EvaluationService#add(domain.Evaluation)
	 */
	@Override
	public void add(Evaluation e){
		dao.add(e);
	}

	/* (non-Javadoc)
	 * @see service.EvaluationService#delete(java.lang.String)
	 */
	@Override
	public void delete(String id){
		dao.delete(id);
	}
	/* (non-Javadoc)
	 * @see service.EvaluationService#update(domain.Evaluation)
	 */
	@Override
	public void update(Evaluation e){
		dao.update(e);
	}

	/* (non-Javadoc)
	 * @see service.EvaluationService#find(java.lang.String)
	 */
	@Override
	public Evaluation find(String id){
		return dao.find(id);
	}
	
	/* (non-Javadoc)
	 * @see service.EvaluationService#findAll(java.lang.String)
	 */
	@Override
	public HashMap<String, Evaluation> findAll(String tch_id){
		return dao.findAll(tch_id);
	}
}
