package jp.co.worksap.hue.model;

import java.sql.Date;
import java.sql.Timestamp;

import jp.co.worksap.hue.model.entity.AppData;
import jp.co.worksap.hue.model.entity.MsaReqData;
import jp.co.worksap.hue.model.entity.PrjReqData;

/**
 * TODO シクった・・・AppDetailDtoと被る。。。
 * @author yakuza
 *
 */
public class AppUpdateDto {
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
	// プロジェクト情報
	private String projectName;
	private String git;					// MSAでも利用
	private String masterMailAddress;
	private String purpose;
	private String projectTypeCode;
	private String dependencyCode;
	// MSA情報
	private String repositoryName;
	private String ciChargePerson;
	private Date testStartDate;
	
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
	
	public MsaReqData getMsaReqData() {
		MsaReqData result = new MsaReqData();
		result.setAppId(appId);
		result.setRepositoryName(repositoryName);
		result.setCiChargePerson(ciChargePerson);
		result.setGit(git);
		result.setTestStartDate(testStartDate);
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
	public Date getTestStartDate() {
		return testStartDate;
	}
	public void setTestStartDate(Date testStartDate) {
		this.testStartDate = testStartDate;
	}
}
