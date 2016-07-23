package jp.co.worksap.hue.model;

public class UserFormDto {
	private String userId;
	private String firstName;
	private String lastName;
	private int ciFlg = 0;
	private String vpId;
	private String langCd;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getCiFlg() {
		return ciFlg;
	}
	public void setCiFlg(int ciFlg) {
		this.ciFlg = ciFlg;
	}
	public String getVpId() {
		return vpId;
	}
	public void setVpId(String vpId) {
		this.vpId = vpId;
	}
	public String getLangCd() {
		return langCd;
	}
	public void setLangCd(String langCd) {
		this.langCd = langCd;
	}
}
