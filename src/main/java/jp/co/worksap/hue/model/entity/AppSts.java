package jp.co.worksap.hue.model.entity;

import groovy.transform.ToString;

@ToString
public class AppSts {
	private String label;
	private String value;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
//	private String appStsCode;
//	private String appStsName;
//	
//	public String getAppStsCode() {
//		return appStsCode;
//	}
//	public void setAppStsCode(String appStsCode) {
//		this.appStsCode = appStsCode;
//	}
//	public String getAppStsName() {
//		return appStsName;
//	}
//	public void setAppStsName(String appStsName) {
//		this.appStsName = appStsName;
//	}
}
