package jp.co.worksap.hue.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import jp.co.worksap.hue.model.UserFormDto;
import jp.co.worksap.hue.model.entity.WapUser;

@Component
@ComponentScan
public class WapUserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public WapUser getUser(String userId) {
		WapUser user = jdbcTemplate.queryForObject(
				"SELECT ID, USER_ID, FIRST_NAME, LAST_NAME, CI_FLG, VP_ID, LANG_CD FROM USRTBL WHERE USER_ID = ?",
				new Object[] {userId},
				new RowMapper<WapUser>() {
					@Override
					public WapUser mapRow(ResultSet rs, int rowNum) throws SQLException {
						WapUser user = new WapUser();
						user.setId(rs.getLong("ID"));
						user.setUserId(rs.getString("USER_ID"));
						user.setFirstNm(rs.getString("FIRST_NAME"));
						user.setLastNm(rs.getString("LAST_NAME"));
						user.setCI(rs.getInt("CI_FLG") == 1);
						user.setVpUserId(rs.getString("VP_ID"));
						user.setLangCd(rs.getString("LANG_CD"));
						return user;
					}
				});
		return user;
	}
	
	@Transactional
	public long regist(UserFormDto dto) {
//		jdbcTemplate.update(
//			"INSERT INTO USRTBL (USER_ID, FIRST_NAME, LAST_NAME, CI_FLG, VP_ID, LANG_CD) VALUES (?, ?, ?, ?, ?, ?)",
//			dto.getUserId(), dto.getFirstName(), dto.getLastName(), dto.getCiFlg(), dto.getVpId(), dto.getLangCd()
//		);
//		return true;
		SimpleJdbcInsert cmd = new SimpleJdbcInsert(jdbcTemplate.getDataSource())
				.withTableName("usrtbl")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_id", dto.getUserId());
		params.put("first_name", dto.getFirstName());
		params.put("last_name", dto.getLastName());
		params.put("ci_flg", dto.getCiFlg());
		params.put("vp_id", dto.getVpId());
		params.put("lang_cd", dto.getLangCd());
		return cmd.executeAndReturnKey(params).longValue();
	}
}
