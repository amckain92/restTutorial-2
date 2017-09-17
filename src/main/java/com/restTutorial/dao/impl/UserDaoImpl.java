package com.restTutorial.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.restTutorial.dao.UserDao;
import com.restTutorial.models.User;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoImpl<User, Long> implements UserDao {

	static User USER_ANDREW = new User(1l, "andrew", "mckain");
	static User USER_BOB = new User(2l, "bob", "jones");
	
	public UserDaoImpl() { super(User.class); }
	
	public User getUserById(Long id) {
		return get(id);
	}

	@SuppressWarnings("unchecked")
	public List<User> searchForUserByName(String name) {
		Session session = getSessionFactory().getCurrentSession();
		
		String userQuery = "FROM User u WHERE (u.firstName LIKE :firstName OR u.lastName LIKE :lastName)";
		Query query = session.createQuery(userQuery);
		query.setString("firstName", "%"+name+"%");
		query.setString("lastName", "%"+name+"%");
		List<User> usersResult = query.list();
		
		return usersResult;
		
		/*
		List<User> users = new ArrayList<User>();
		
		if(name != null){
			if("andrew".startsWith(name)){
				users.add(USER_ANDREW);
			} else if("bob".startsWith(name)){
				users.add(USER_BOB);
			}
		} else {
			users.add(USER_ANDREW);
			users.add(USER_BOB);
		}
		return users;
		*/
	}
	
}
