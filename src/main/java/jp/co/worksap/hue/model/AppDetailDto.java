package jp.co.worksap.hue.model;

import jp.co.worksap.hue.model.entity.AppData;
import jp.co.worksap.hue.model.entity.MsaReqData;
import jp.co.worksap.hue.model.entity.PrjReqData;

public class AppDetailDto {
	private AppData appData;
	private PrjReqData prjReqData;
	private MsaReqData msaReqData;
	
	public AppData getAppData() {
		return appData;
	}
	public void setAppData(AppData appData) {
		this.appData = appData;
	}
	public PrjReqData getPrjReqData() {
		return prjReqData;
	}
	public void setPrjReqData(PrjReqData prjReqData) {
		this.prjReqData = prjReqData;
	}
	public MsaReqData getMsaReqData() {
		return msaReqData;
	}
	public void setMsaReqData(MsaReqData msaReqData) {
		this.msaReqData = msaReqData;
	}
}
