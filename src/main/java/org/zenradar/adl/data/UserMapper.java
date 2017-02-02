package org.zenradar.adl.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.zenradar.adl.model.User;

public class UserMapper implements ResultSetMapper<User> {

	public static UserMapper INSTANCE = new UserMapper();

	@Override
	public User map(int idx, ResultSet rs, StatementContext ctx) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPhone(rs.getString("phone"));
		user.setEmail(rs.getString("email"));
		return user;
	}
}
