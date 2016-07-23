package jp.co.worksap.hue.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.worksap.hue.model.entity.PrjReqData;

@Component
@ComponentScan
public class PrjReqDataDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PrjReqData getById(long appId) {
		RowMapper<PrjReqData> mapper = new BeanPropertyRowMapper<>(PrjReqData.class);
		PrjReqData result = jdbcTemplate.queryForObject(
				"SELECT APP_ID, PROJECT_NAME, GIT, MASTER_MAIL_ADDRESS, PURPOSE, PROJECT_TYPE_CODE, DEPENDENCY_CODE FROM APP_REQUEST_PROJECT WHERE APP_ID = ?",
				new Object[] {appId}, mapper);
		return result;
	}
	
	public long regist(PrjReqData data) {
		SimpleJdbcInsert cmd = new SimpleJdbcInsert(jdbcTemplate.getDataSource())
									.withTableName("app_request_project");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("app_id", data.getAppId());
		params.put("project_name", data.getProjectName());
		params.put("git", data.getGit());
		params.put("master_mail_address", data.getMasterMailAddress());
		params.put("project_type_code", data.getProjectTypeCode());
		params.put("dependency_code", data.getDependencyCode());
		params.put("purpose", data.getPurpose());
		cmd.execute(params);
		return data.getAppId();
	}
	
	@Transactional
	public void update(long appId, PrjReqData data) {
		jdbcTemplate.update(
			getUpdateSQL(),
			new Object[] {
				data.getProjectName(), data.getGit(), data.getMasterMailAddress(),
				data.getPurpose(), data.getProjectTypeCode(), data.getDependencyCode(),
				appId
			}
		);
	}
	
	private String getUpdateSQL() {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE APP_REQUEST_PROJECT SET PROJECT_NAME = ?, GIT = ?, MASTER_MAIL_ADDRESS = ?, ");
		sql.append("PURPOSE = ?, PROJECT_TYPE_CODE = ?, DEPENDENCY_CODE = ? ");
		sql.append("WHERE APP_ID = ?");
		return sql.toString();
	}
}
