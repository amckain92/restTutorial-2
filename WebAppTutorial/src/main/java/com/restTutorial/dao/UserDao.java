package com.restTutorial.dao;

import java.util.List;

import com.restTutorial.models.User;

public interface UserDao extends GenericDao<User, Long> {
	User getUserById(Long id);
	List<User> searchForUserByName(String name);
}
