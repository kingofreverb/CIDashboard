package jp.co.worksap.hue.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.co.worksap.hue.model.entity.VersionNo;

@Component
@ComponentScan
public class VersionNoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<VersionNo> get() {
		RowMapper<VersionNo> mapper = new BeanPropertyRowMapper<>(VersionNo.class);
		List<VersionNo> result = jdbcTemplate.query(
				"SELECT VERSION_NO, RELEASE_DATE FROM VERSION_MST ORDER BY VERSION_NO", mapper);
		return result;
	}
}
