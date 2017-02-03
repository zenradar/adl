package org.zenradar.adl.data;

import java.util.List;

import org.zenradar.adl.model.User;

/**
 * User data access object interface
 * @see UserDaoImpl
 * @author adam
 *
 */
public interface UserDao {

	User findByName(String name);
	
	List<User> findAll();

}