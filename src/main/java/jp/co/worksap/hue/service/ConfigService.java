package jp.co.worksap.hue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.worksap.hue.model.dao.AppStsDao;
import jp.co.worksap.hue.model.dao.AppTypeDao;
import jp.co.worksap.hue.model.dao.DependencyMstDao;
import jp.co.worksap.hue.model.dao.ProjectTypeDao;
import jp.co.worksap.hue.model.dao.VersionNoDao;
import jp.co.worksap.hue.model.entity.AppSts;
import jp.co.worksap.hue.model.entity.AppType;
import jp.co.worksap.hue.model.entity.DependencyMst;
import jp.co.worksap.hue.model.entity.ProjectType;
import jp.co.worksap.hue.model.entity.VersionNo;

@Service
public class ConfigService {
	@Autowired
	private AppTypeDao appTypeDao;
	@Autowired
	private AppStsDao appStsDao;
	@Autowired
	private VersionNoDao versionNoDao;
	@Autowired
	private ProjectTypeDao projectTypeDao;
	@Autowired
	private DependencyMstDao dependencyMstDao;
	
	public List<AppType> getAppType() {
		return appTypeDao.get();
	}
	
	public List<AppSts> getAppSts() {
		return appStsDao.get();
	}
	
	public List<VersionNo> getVersionNo() {
		return versionNoDao.get();
	}
	
	public List<ProjectType> getProjectType() {
		return projectTypeDao.get();
	}
	
	public List<DependencyMst> getDependencyMst() {
		return dependencyMstDao.get();
	}
}
