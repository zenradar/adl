package org.zenradar.adl.data;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zenradar.adl.config.RootConfig;
import org.zenradar.adl.config.WebConfig;
import org.zenradar.adl.model.Book;

/**
 * Test for UserDao
 * 
 * @author adam
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
@ActiveProfiles("h2-unit-test")
public class BookDaoTest {

	private EmbeddedDatabase db;

	@Before
	public void setUp() {
		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db/sql/create-test-db.sql")
				.addScript("db/sql/seed-test-data.sql").build();
	}

	@Test
	public void testFindByname() {
		BookDaoImpl bookDao = new BookDaoImpl(db);
		Book book = bookDao.findByTitle("War and Peace");
		Assert.assertNotNull(book);
		Assert.assertEquals(2, book.getId().intValue());
		Assert.assertEquals("9781400079988", book.getIsbn());

	}


	@Test
	public void testFindAll() {
		BookDaoImpl bookDao = new BookDaoImpl(db);

		List<Book> books = bookDao.findAll();

		Assert.assertNotNull(books);

	}


	@After
	public void tearDown() {
		db.shutdown();
	}

}