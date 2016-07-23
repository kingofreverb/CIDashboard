package jp.co.worksap.hue.enums;

public enum AppTypeMst {
	APP_PRJ,
	APP_MSA
	;
	
	private AppTypeMst() {
		
	}
	
	public static AppTypeMst getAppType(String value) {
		for (AppTypeMst appType : AppTypeMst.values()) {
			if (appType.toString().equals(value.toUpperCase())) {
				return appType;
			}
		}
		return null;
	}
}
