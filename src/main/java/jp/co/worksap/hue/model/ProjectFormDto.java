package jp.co.worksap.hue.model;

import jp.co.worksap.hue.model.entity.PrjReqData;

public class ProjectFormDto extends AppFormDto {
	// プロジェクト情報
	private String projectName;
	private String git;
	private String masterMailAddress;
	private String purpose;
	private String projectTypeCode;
	private String dependencyCode;
	
	public PrjReqData getPrjReqData() {
		PrjReqData result = new PrjReqData();
		result.setAppId(appId);
		result.setProjectName(projectName);
		result.setProjectTypeCode(projectTypeCode);
		result.setGit(git);
		result.setMasterMailAddress(masterMailAddress);
		result.setDependencyCode(dependencyCode);
		result.setPurpose(purpose);
		return result;
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
