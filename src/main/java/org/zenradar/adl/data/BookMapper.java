package org.zenradar.adl.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.zenradar.adl.model.Book;

public class BookMapper implements ResultSetMapper<Book> {

	public static BookMapper INSTANCE = new BookMapper();
	
	@Override
	public Book map(int idx, ResultSet rs, StatementContext ctx) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt("id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setIsbn(rs.getString("isbn"));
		return book;
	}
}