package org.zenradar.adl.data;

import java.util.List;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zenradar.adl.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;

	@Override
	public User findByName(String name) {

		DBI dbi = new DBI(datasource);
		User user;
		try (Handle handle = dbi.open()) {
			user = handle.createQuery("SELECT * FROM users WHERE name=:name").bind("name", name)
					.map(UserMapper.INSTANCE).first();
		}

		return user;
	}

	@Override
	public List<User> findAll() {
		DBI dbi = new DBI(datasource);
		List<User> users = null;
		try (Handle handle = dbi.open()) {
			users = handle.createQuery("SELECT * FROM users").map(UserMapper.INSTANCE).list();
		}

		return users;
	}

}