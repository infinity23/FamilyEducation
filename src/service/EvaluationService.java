package service;

import java.util.HashMap;

import domain.Evaluation;

public interface EvaluationService {

	void add(Evaluation e);

	void delete(String id);

	void update(Evaluation e);

	Evaluation find(String id);

	HashMap<String, Evaluation> findAll(String tch_id);

}