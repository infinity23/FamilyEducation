package dao;

import java.util.HashMap;

import domain.Evaluation;

public interface EvaluationDao {

	void add(Evaluation a);

	void update(Evaluation a);

	void delete(String id);

	Evaluation find(String id);

	HashMap<String, Evaluation> findAll(String tch_id);

}