package org.zenradar.adl.config.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Creates and populates an embedded h2 database for unit testing.
 * The profile h2 is used for production.
 * @see H2DataSource
 * 
 * @author adam
 *
 */

@Profile("h2-unit-test")
@Configuration
public class TestH2DataSource {

	// jdbc:h2:mem:testdb
	@Bean
	public DataSource dataSource() {
		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2)
				.addScript("db/sql/create-test-db.sql")
				.addScript("db/sql/seed-test-data.sql")
				.build();

		return db;
	}
}