package org.zenradar.adl.data;

import java.util.List;

import org.zenradar.adl.model.User;

public interface UserDao {

	User findByName(String name);
	
	List<User> findAll();

}