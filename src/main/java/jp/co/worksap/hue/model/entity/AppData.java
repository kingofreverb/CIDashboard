package jp.co.worksap.hue.model.entity;

import java.sql.Timestamp;

import groovy.transform.ToString;

@ToString
public class AppData {
	private long appId;
	private String appTitle;
	private String appTypeCode;
	private String appUserId;
	private String appUserNm;
	private String appStsCode;
	private String appStsName;
	private String versionNo;
	private String appChargeUserId;
	private String appChargeUserNm;
	private Timestamp appTime;
	private Timestamp updTime;
	private String appMemo;
	
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
	public String getAppStsName() {
		return appStsName;
	}
	public void setAppStsName(String appStsName) {
		this.appStsName = appStsName;
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
