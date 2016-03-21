package cz.uhk.braces.dataset.main;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.dataset.AbstractDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.util.InMemoryResource;
import org.springframework.stereotype.Component;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.sql.DataSource;

/**
 * User: Lukas Rezner
 * Date: 20.3.16
 */
@Component
public class ClearDatabaseDataset  extends AbstractDataset {
	private static final Logger LOG = LoggerFactory.getLogger(ClearDatabaseDataset.class);

	@Value("${hibernate.default_schema}")
	private String schemaName;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	protected void loadData() {
		String dropStatement = "drop schema if exists " + schemaName + ";";
		LOG.info("Execute mysql statement '{}'.", dropStatement);
		JdbcTestUtils.executeSqlScript(jdbcTemplate, new InMemoryResource(dropStatement), false);

		String createStatement = "CREATE SCHEMA " + schemaName + " DEFAULT CHARACTER SET utf8 ; use " + schemaName+" ;";
		LOG.info("Execute mysql statement '{}'.", createStatement);
		JdbcTestUtils.executeSqlScript(jdbcTemplate, new InMemoryResource(createStatement), false);

	}

	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "clearDatabaseDataset");
	}
}
