package jp.co.worksap.hue.model.entity;

import java.sql.Date;

import groovy.transform.ToString;

@ToString
public class VersionNo {
	private String versionNo;
	private Date releaseDate;
	
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
