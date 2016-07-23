package jp.co.worksap.hue.model;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jp.co.worksap.hue.model.entity.WapUser;

public class LoginUser extends User {
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String firstNm;
	private String lastNm;
	private boolean isCI;
	private String vpUserId;
	private String langCd;
	
	public LoginUser(WapUser user) {
		super(user.getUserId(), "", true, true, true, true, new ArrayList<GrantedAuthority>());
		this.userId = user.getUserId();
		this.firstNm = user.getFirstNm();
		this.lastNm = user.getLastNm();
		this.isCI = user.isCI();
		this.vpUserId = user.getVpUserId();
		this.langCd = user.getLangCd();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	public boolean isCI() {
		return isCI;
	}

	public void setCI(boolean isCI) {
		this.isCI = isCI;
	}

	public String getVpUserId() {
		return vpUserId;
	}

	public void setVpUserId(String vpUserId) {
		this.vpUserId = vpUserId;
	}

	public String getLangCd() {
		return langCd;
	}

	public void setLangCd(String langCd) {
		this.langCd = langCd;
	}
}
