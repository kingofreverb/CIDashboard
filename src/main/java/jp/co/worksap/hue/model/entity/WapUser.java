package jp.co.worksap.hue.model.entity;

import groovy.transform.ToString;

@ToString
public class WapUser {
	private String userId;
	private String firstNm;
	private String lastNm;
	private boolean isCI;
	private String vpUserId;
	private String langCd;

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
