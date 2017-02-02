package org.zenradar.adl.data;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.zenradar.adl.model.Book;

@RegisterMapper(BookMapper.class)
public interface BookDao {

	@SqlQuery("SELECT * FROM books WHERE title=:title")
	Book findByTitle(@Bind("title") String title);
	
	@SqlQuery("SELECT * FROM books")
	List<Book> findAll();

	@SqlQuery("SELECT * FROM books b LEFT JOIN borrowed o ON (b.id = o.book_id) WHERE o.user_id = :userId")
	List<Book> findBorrowed(@Bind("userId") int userId);

}