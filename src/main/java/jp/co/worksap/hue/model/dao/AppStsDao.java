package jp.co.worksap.hue.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.co.worksap.hue.model.entity.AppSts;

@Component
@ComponentScan
public class AppStsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<AppSts> get() {
		RowMapper<AppSts> mapper = new BeanPropertyRowMapper<>(AppSts.class);
		List<AppSts> result = jdbcTemplate.query(
				"SELECT APP_STS_CODE VALUE, APP_STS_NAME LABEL FROM APP_STS_MST ORDER BY APP_STS_CODE", mapper);
		return result;
	}
}
