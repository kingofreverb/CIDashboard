package jp.co.worksap.hue.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.co.worksap.hue.model.entity.ProjectType;

@Component
@ComponentScan
public class ProjectTypeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ProjectType> get() {
		RowMapper<ProjectType> mapper = new BeanPropertyRowMapper<>(ProjectType.class);
		List<ProjectType> result = jdbcTemplate.query(
				"SELECT PROJECT_TYPE_CODE, PROJECT_TYPE_NAME FROM PROJECT_TYPE_MST ORDER BY PROJECT_TYPE_CODE", mapper);
		return result;
	}
}
