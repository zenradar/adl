package org.zenradar.adl.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * RootConfig
 * 
 * @author adam
 *
 */
@ComponentScan({ "org.zenradar.adl" })
@Configuration
public class RootConfig {

	@Autowired
	DataSource dataSource;

}