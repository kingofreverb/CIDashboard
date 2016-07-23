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

import jp.co.worksap.hue.model.entity.MsaReqData;

@Component
@ComponentScan
public class MsaReqDataDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MsaReqData getById(long appId) {
		RowMapper<MsaReqData> mapper = new BeanPropertyRowMapper<>(MsaReqData.class);
		MsaReqData result = jdbcTemplate.queryForObject(
				"SELECT APP_ID, REPOSITORY_NAME, CI_CHARGE_PERSON, GIT, TEST_START_DATE FROM APP_REQUEST_MSA WHERE APP_ID = ?",
				new Object[] {appId}, mapper);
		return result;
	}
	
	@Transactional
	public long regist(MsaReqData data) {
		SimpleJdbcInsert cmd = new SimpleJdbcInsert(jdbcTemplate.getDataSource())
									.withTableName("app_request_msa");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("app_id", data.getAppId());
		params.put("repository_name", data.getRepositoryName());
		params.put("ci_charge_person", data.getCiChargePerson());
		params.put("git", data.getGit());
		params.put("test_start_date", data.getTestStartDate());
		cmd.execute(params);
		return data.getAppId();
	}
	
	@Transactional
	public void update(long appId, MsaReqData data) {
		jdbcTemplate.update(
			getUpdateSQL(),
			new Object[] {
				data.getRepositoryName(), data.getCiChargePerson(), data.getGit(),
				data.getTestStartDate(), appId
			}
		);
	}
	
	private String getUpdateSQL() {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE APP_REQUEST_MSA SET REPOSITORY_NAME = ?, CI_CHARGE_PERSON = ?, GIT = ?, ");
		sql.append("TEST_START_DATE = ? WHERE APP_ID = ?");
		return sql.toString();
	}
}
