package jp.co.worksap.hue.model.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.worksap.hue.model.entity.AppData;

@Component
@ComponentScan
public class AppDataDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AppData getById(long appId) {
		RowMapper<AppData> mapper = new BeanPropertyRowMapper<>(AppData.class);
		AppData result = jdbcTemplate.queryForObject(
				getByIdSQL(),
				new Object[] {appId}, mapper);
		return result;
	}
	
	public List<AppData> getAppliedData() {
		RowMapper<AppData> mapper = new BeanPropertyRowMapper<>(AppData.class);
		List<AppData> result = jdbcTemplate.query(
				getAppliedDataSQL(),
				new Object[] {"STS003"}, mapper);
		return result;
	}
	
	public List<AppData> getCompletedData() {
		RowMapper<AppData> mapper = new BeanPropertyRowMapper<>(AppData.class);
		List<AppData> result = jdbcTemplate.query(
				getCompletedDataSQL(),
				new Object[] {"STS003"}, mapper);
		return result;
	}
	
	public List<AppData> getMyAppliedData(String userId) {
		RowMapper<AppData> mapper = new BeanPropertyRowMapper<>(AppData.class);
		List<AppData> result = jdbcTemplate.query(
				getMyAppliedDataSQL(),
				new Object[] {userId}, mapper);
		return result;
	}
	
	@Transactional
	public long regist(AppData data) {
		SimpleJdbcInsert cmd = new SimpleJdbcInsert(jdbcTemplate.getDataSource())
									.withTableName("app_table")
									.usingGeneratedKeyColumns("app_id");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("app_title", data.getAppTitle());
		params.put("app_type_code", data.getAppTypeCode());
		params.put("app_user_id", data.getAppUserId());
		params.put("app_user_nm", data.getAppUserNm());
		params.put("app_sts_code", "STS001");
		params.put("version_no", data.getVersionNo());
		params.put("app_time", new Timestamp(System.currentTimeMillis()));
		params.put("app_memo", data.getAppMemo());
		return cmd.executeAndReturnKey(params).longValue();
	}
	
	@Transactional
	public void update(AppData data) {
		jdbcTemplate.update(
			getUpdateSQL(),
			new Object[] {
				data.getAppTitle(), data.getAppTypeCode(), data.getAppUserId(), data.getAppUserNm(),
				data.getAppStsCode(), data.getVersionNo(), data.getAppChargeUserId(), data.getAppChargeUserNm(),
				new Timestamp(System.currentTimeMillis()), data.getAppMemo(), data.getAppId()
			}
		);
	}
	
	@Transactional
	public void delete(long appId) {
		jdbcTemplate.update(
			getDeleteSQL(),
			new Object[] {appId}
		);
		
	}
	
	private String getByIdSQL() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT A.APP_ID, A.APP_TITLE, A.APP_TYPE_CODE, A.APP_USER_ID, A.APP_USER_NM, A.APP_STS_CODE, ");
		sql.append("S.APP_STS_NAME, A.VERSION_NO, A.APP_CHARGE_USER_ID, A.APP_CHARGE_USER_NM, A.APP_TIME, A.UPD_TIME, ");
		sql.append("A.APP_MEMO FROM APP_TABLE A, APP_STS_MST S WHERE A.APP_ID = ? AND A.APP_STS_CODE = S.APP_STS_CODE");
		return sql.toString();
	}
	
	private String getAppliedDataSQL() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT A.APP_ID, A.APP_TITLE, A.APP_TYPE_CODE, T.APP_TYPE_NAME, A.APP_USER_ID, A.APP_USER_NM, A.APP_STS_CODE, ");
		sql.append("S.APP_STS_NAME, A.VERSION_NO, A.APP_CHARGE_USER_ID, A.APP_CHARGE_USER_NM, A.APP_TIME, A.UPD_TIME, ");
		sql.append("A.APP_MEMO FROM APP_TABLE A, APP_TYPE_MST T, APP_STS_MST S WHERE A.APP_STS_CODE != ? ");
		sql.append("AND A.APP_TYPE_CODE = T.APP_TYPE_CODE AND A.APP_STS_CODE = S.APP_STS_CODE");
		return sql.toString();
	}
	
	private String getCompletedDataSQL() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT A.APP_ID, A.APP_TITLE, A.APP_TYPE_CODE, T.APP_TYPE_NAME, A.APP_USER_ID, A.APP_USER_NM, A.APP_STS_CODE, ");
		sql.append("S.APP_STS_NAME, A.VERSION_NO, A.APP_CHARGE_USER_ID, A.APP_CHARGE_USER_NM, A.APP_TIME, A.UPD_TIME, ");
		sql.append("A.APP_MEMO FROM APP_TABLE A, APP_TYPE_MST T, APP_STS_MST S WHERE A.APP_STS_CODE = ? ");
		sql.append("AND A.APP_TYPE_CODE = T.APP_TYPE_CODE AND A.APP_STS_CODE = S.APP_STS_CODE");
		return sql.toString();
	}
	
	private String getMyAppliedDataSQL() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT A.APP_ID, A.APP_TITLE, A.APP_TYPE_CODE, T.APP_TYPE_NAME, A.APP_USER_ID, A.APP_USER_NM, A.APP_STS_CODE, ");
		sql.append("S.APP_STS_NAME, A.VERSION_NO, A.APP_CHARGE_USER_ID, A.APP_CHARGE_USER_NM, A.APP_TIME, A.UPD_TIME, ");
		sql.append("A.APP_MEMO FROM APP_TABLE A, APP_TYPE_MST T, APP_STS_MST S WHERE A.APP_USER_ID = ? ");
		sql.append("AND A.APP_TYPE_CODE = T.APP_TYPE_CODE AND A.APP_STS_CODE = S.APP_STS_CODE");
		return sql.toString();
	}
	
	private String getUpdateSQL() {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE APP_TABLE SET APP_TITLE = ?, APP_TYPE_CODE = ?, APP_USER_ID = ?, APP_USER_NM = ?, ");
		sql.append("APP_STS_CODE = ?, VERSION_NO = ?, APP_CHARGE_USER_ID = ?, APP_CHARGE_USER_NM = ?, UPD_TIME = ?, ");
		sql.append("APP_MEMO = ? WHERE APP_ID = ?");
		return sql.toString();
	}
	
	private String getDeleteSQL() {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM APP_TABLE WHERE APP_ID = ?");
		return sql.toString();
	}
}
