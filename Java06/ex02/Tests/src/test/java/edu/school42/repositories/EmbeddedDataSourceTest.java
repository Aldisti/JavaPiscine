package edu.school42.numbers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import java.sql.*;
import javax.sql.*;

public class EmbeddedDataSourceTest {

	@Test
	public void	checkConnection() {
		DataSource	ds ;
		Connection	con;

		try {
			ds = new EmbeddedDatabaseBuilder()
				.generateUniqueName(true)
				.setType(EmbeddedDatabaseType.HSQL)
				.setScriptEncoding("UTF-8")
				.ignoreFailedDrops(true)
				.addScript("/schema.sql")
				.addScript("/data.sql")
				.build();
			con = ds.getConnection();
			assertNotNull(con);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return ;
		}
	}
}

