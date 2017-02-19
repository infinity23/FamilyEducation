package service;

import exception.WrongUserType;

public interface UserService {

	<T> void addUser(T user) throws WrongUserType;

	<T> T findUser(T user);

	<T> void deleteUser(T user) throws WrongUserType;

	<T> void updateUser(T user) throws WrongUserType;

}