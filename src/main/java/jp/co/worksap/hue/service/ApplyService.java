package jp.co.worksap.hue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.worksap.hue.enums.AppTypeMst;
import jp.co.worksap.hue.model.AppDetailDto;
import jp.co.worksap.hue.model.AppUpdateDto;
import jp.co.worksap.hue.model.MsaFormDto;
import jp.co.worksap.hue.model.ProjectFormDto;
import jp.co.worksap.hue.model.dao.AppDataDao;
import jp.co.worksap.hue.model.dao.MsaReqDataDao;
import jp.co.worksap.hue.model.dao.PrjReqDataDao;
import jp.co.worksap.hue.model.entity.AppData;

@Service
public class ApplyService {
	@Autowired
	private AppDataDao appDataDao;
	@Autowired
	private PrjReqDataDao prjReqDataDao;
	@Autowired
	private MsaReqDataDao msaReqDataDao;
	
	public List<AppData> getApplyingData() {
		return appDataDao.getAppliedData();
	}
	
	public List<AppData> getCompletedData() {
		return appDataDao.getCompletedData();
	}
	
	public List<AppData> getMyAppliedData(String userId) {
		return appDataDao.getMyAppliedData(userId);
	}
	
	public AppDetailDto getApplyDtlData(long appId) {
		AppDetailDto dto = new AppDetailDto();
		AppData appData = appDataDao.getById(appId);
		dto.setAppData(appData);
		switch (AppTypeMst.getAppType(appData.getAppTypeCode())) {
			case APP_PRJ:
				dto.setPrjReqData(prjReqDataDao.getById(appId));
				break;
			case APP_MSA:
				dto.setMsaReqData(msaReqDataDao.getById(appId));
				break;
		}
		return dto;
	}

	@Transactional
	public long registPrjData(ProjectFormDto dto) {
		long appId = appDataDao.regist(dto.getAppData());
		dto.setAppId(appId);
		prjReqDataDao.regist(dto.getPrjReqData());
		return appId;
	}
	
	@Transactional
	public long registMsaData(MsaFormDto dto) {
		long appId = appDataDao.regist(dto.getAppData());
		dto.setAppId(appId);
		msaReqDataDao.regist(dto.getMsaReqData());
		return appId;
	}
	
	@Transactional
	public void updateApplyData(long appId, AppUpdateDto dto) {
		appDataDao.update(dto.getAppData());
		switch (AppTypeMst.getAppType(dto.getAppData().getAppTypeCode())) {
			case APP_PRJ:
				prjReqDataDao.update(appId, dto.getPrjReqData());
				break;
			case APP_MSA:
				msaReqDataDao.update(appId, dto.getMsaReqData());
				break;
		}
	}
	
	@Transactional
	public void deleteApplyData(long appId, String appTypeCode) {
		switch (AppTypeMst.getAppType(appTypeCode)) {
			case APP_PRJ:
				prjReqDataDao.delete(appId);
				break;
			case APP_MSA:
				msaReqDataDao.delete(appId);
				break;
		}
		appDataDao.delete(appId);
	}
}
