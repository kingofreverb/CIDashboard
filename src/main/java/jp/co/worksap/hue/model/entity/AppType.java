package jp.co.worksap.hue.model.entity;

import groovy.transform.ToString;

@ToString
public class AppType {
	private String value;
	private String label;
	private int ord;
	
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
	public int getOrd() {
		return ord;
	}
	public void setOrd(int ord) {
		this.ord = ord;
	}
//	private String appTypeCode;
//	private String appTypeName;
//	private int ord;
//	
//	public String getAppTypeCode() {
//		return appTypeCode;
//	}
//	public void setAppTypeCode(String appTypeCode) {
//		this.appTypeCode = appTypeCode;
//	}
//	public String getAppTypeName() {
//		return appTypeName;
//	}
//	public void setAppTypeName(String appTypeName) {
//		this.appTypeName = appTypeName;
//	}
//	public int getOrd() {
//		return ord;
//	}
//	public void setOrd(int ord) {
//		this.ord = ord;
//	}
}
