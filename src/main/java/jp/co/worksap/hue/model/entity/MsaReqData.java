package jp.co.worksap.hue.model.entity;

import java.sql.Date;

import groovy.transform.ToString;

@ToString
public class MsaReqData {
	private long appId;
	private String repositoryName;
	private String ciChargePerson;
	private String git;
	private Date testStartDate;
	
	public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	public String getRepositoryName() {
		return repositoryName;
	}
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	public String getCiChargePerson() {
		return ciChargePerson;
	}
	public void setCiChargePerson(String ciChargePerson) {
		this.ciChargePerson = ciChargePerson;
	}
	public String getGit() {
		return git;
	}
	public void setGit(String git) {
		this.git = git;
	}
	public Date getTestStartDate() {
		return testStartDate;
	}
	public void setTestStartDate(Date testStartDate) {
		this.testStartDate = testStartDate;
	}
}
