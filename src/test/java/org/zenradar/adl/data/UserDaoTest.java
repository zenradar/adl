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
import org.zenradar.adl.model.User;

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
public class UserDaoTest {

	private EmbeddedDatabase db;

	@Before
	public void setUp() {
		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db/sql/create-test-db.sql")
				.addScript("db/sql/seed-test-data.sql").build();
	}

	@Test
	public void testFindByname() {
		UserDaoImpl userDao = new UserDaoImpl(db);
		User user = userDao.findByName("Sterling Mallory Archer");
		Assert.assertNotNull(user);
		Assert.assertEquals(1, user.getId().intValue());
		Assert.assertEquals("danger-zone@gmail.com", user.getEmail());

	}

	@Test
	public void testFindNoHomer() {
		UserDaoImpl userDao = new UserDaoImpl(db);
		User user = userDao.findByName("Homer Simpson");
		Assert.assertNull(user);
	}

	@Test
	public void testFindAll() {
		UserDaoImpl userDao = new UserDaoImpl(db);

		List<User> users = userDao.findAll();

		Assert.assertNotNull(users);

	}


	@After
	public void tearDown() {
		db.shutdown();
	}

}