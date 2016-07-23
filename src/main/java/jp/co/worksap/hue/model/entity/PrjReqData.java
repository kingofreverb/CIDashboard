package jp.co.worksap.hue.model.entity;

import groovy.transform.ToString;

@ToString
public class PrjReqData {
	private long appId;
	private String projectName;
	private String git;
	private String masterMailAddress;
	private String purpose;
	private String projectTypeCode;
	private String dependencyCode;
	
	public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getGit() {
		return git;
	}
	public void setGit(String git) {
		this.git = git;
	}
	public String getMasterMailAddress() {
		return masterMailAddress;
	}
	public void setMasterMailAddress(String masterMailAddress) {
		this.masterMailAddress = masterMailAddress;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getProjectTypeCode() {
		return projectTypeCode;
	}
	public void setProjectTypeCode(String projectTypeCode) {
		this.projectTypeCode = projectTypeCode;
	}
	public String getDependencyCode() {
		return dependencyCode;
	}
	public void setDependencyCode(String dependencyCode) {
		this.dependencyCode = dependencyCode;
	}
}
