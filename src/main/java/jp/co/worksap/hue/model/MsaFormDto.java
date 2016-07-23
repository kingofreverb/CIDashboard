package jp.co.worksap.hue.model;

import java.sql.Date;

import jp.co.worksap.hue.model.entity.MsaReqData;

public class MsaFormDto extends AppFormDto {
	// MSA情報
	private String repositoryName;
	private String ciChargePerson;
	private String git;
	private Date testStartDate;
	
	public MsaReqData getMsaReqData() {
		MsaReqData result = new MsaReqData();
		result.setAppId(appId);
		result.setRepositoryName(repositoryName);
		result.setCiChargePerson(ciChargePerson);
		result.setGit(git);
		result.setTestStartDate(testStartDate);
		return result;
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
