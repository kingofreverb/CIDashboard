package jp.co.worksap.hue.model;

import java.sql.Timestamp;

import jp.co.worksap.hue.model.entity.AppData;

public class AppFormDto {
	// 基本情報
	protected long appId;
	protected String appTitle;
	protected String appTypeCode;
	protected String appUserId;
	protected String appUserNm;
	protected String appStsCode;
	protected String versionNo;
	protected String appChargeUserId;
	protected String appChargeUserNm;
	protected Timestamp appTime;
	protected Timestamp updTime;
	protected String appMemo;
	
	public AppData getAppData() {
		AppData result = new AppData();
		result.setAppId(appId);
		result.setAppTitle(appTitle);
		result.setAppTypeCode(appTypeCode);
		result.setAppUserId(appUserId);
		result.setAppUserNm(appUserNm);
		result.setAppStsCode(appStsCode);
		result.setVersionNo(versionNo);
		result.setAppChargeUserId(appChargeUserId);
		result.setAppChargeUserNm(appChargeUserNm);
		result.setAppTime(appTime);
		result.setUpdTime(updTime);
		result.setAppMemo(appMemo);
		return result;
	}
	
	public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	public String getAppTitle() {
		return appTitle;
	}
	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}
	public String getAppTypeCode() {
		return appTypeCode;
	}
	public void setAppTypeCode(String appTypeCode) {
		this.appTypeCode = appTypeCode;
	}
	public String getAppUserId() {
		return appUserId;
	}
	public void setAppUserId(String appUserId) {
		this.appUserId = appUserId;
	}
	public String getAppUserNm() {
		return appUserNm;
	}
	public void setAppUserNm(String appUserNm) {
		this.appUserNm = appUserNm;
	}
	public String getAppStsCode() {
		return appStsCode;
	}
	public void setAppStsCode(String appStsCode) {
		this.appStsCode = appStsCode;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public String getAppChargeUserId() {
		return appChargeUserId;
	}
	public void setAppChargeUserId(String appChargeUserId) {
		this.appChargeUserId = appChargeUserId;
	}
	public String getAppChargeUserNm() {
		return appChargeUserNm;
	}
	public void setAppChargeUserNm(String appChargeUserNm) {
		this.appChargeUserNm = appChargeUserNm;
	}
	public Timestamp getAppTime() {
		return appTime;
	}
	public void setAppTime(Timestamp appTime) {
		this.appTime = appTime;
	}
	public Timestamp getUpdTime() {
		return updTime;
	}
	public void setUpdTime(Timestamp updTime) {
		this.updTime = updTime;
	}
	public String getAppMemo() {
		return appMemo;
	}
	public void setAppMemo(String appMemo) {
		this.appMemo = appMemo;
	}
}
