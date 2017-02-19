package service;

import java.util.HashMap;

import domain.Info;

public interface InfoService {

	void add(Info info);

	void delete(String id);

	void update(Info info);

	Info find(String id);

	HashMap<String, Info> findByStuID(String id);

	HashMap<String, Info> findByTchID(String id);

}