package jp.co.worksap.hue.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.co.worksap.hue.model.entity.DependencyMst;

@Component
@ComponentScan
public class DependencyMstDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<DependencyMst> get() {
		RowMapper<DependencyMst> mapper = new BeanPropertyRowMapper<>(DependencyMst.class);
		List<DependencyMst> result = jdbcTemplate.query(
				"SELECT DEPENDENCY_CODE, DEPENDENCY_NAME FROM DEPENDENCY_MST ORDER BY DEPENDENCY_CODE", mapper);
		return result;
	}
}
