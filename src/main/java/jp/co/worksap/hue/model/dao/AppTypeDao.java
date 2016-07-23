package jp.co.worksap.hue.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.co.worksap.hue.model.entity.AppType;

@Component
@ComponentScan
public class AppTypeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<AppType> get() {
		RowMapper<AppType> mapper = new BeanPropertyRowMapper<>(AppType.class);
		List<AppType> result = jdbcTemplate.query(
				"SELECT APP_TYPE_CODE VALUE, APP_TYPE_NAME LABEL, ORD FROM APP_TYPE_MST ORDER BY ORD", mapper);
		return result;
	}
}
