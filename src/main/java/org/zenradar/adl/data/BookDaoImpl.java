package org.zenradar.adl.data;

import java.util.List;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zenradar.adl.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	DataSource datasource;


	@Override
	public Book findByTitle(String title) {
		DBI dbi = new DBI(datasource);
		Book book;
		try (Handle handle = dbi.open()) {
			book = handle.createQuery("SELECT * FROM books WHERE title=:title").bind("title", title)
					.map(BookMapper.INSTANCE).first();
		}

		return book;
	}

	@Override
	public List<Book> findAll() {
		DBI dbi = new DBI(datasource);
		List<Book> books = null;
		try (Handle handle = dbi.open()) {
			books = handle.createQuery("SELECT * FROM books").map(BookMapper.INSTANCE).list();
		}

		return books;
	}

	@Override
	public List<Book> findBorrowed(int userId) {
		DBI dbi = new DBI(datasource);
		List<Book> books = null;
		try (Handle handle = dbi.open()) {
			books = handle
					.createQuery(
							"SELECT * FROM BOOKS b LEFT JOIN borrowed o ON (b.id = o.book_id) WHERE o.user_id = :userId")
					.map(BookMapper.INSTANCE).bind("userId", userId).list();
		}

		return books;
	}
}