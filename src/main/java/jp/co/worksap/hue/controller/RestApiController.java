package jp.co.worksap.hue.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.worksap.hue.model.AppDetailDto;
import jp.co.worksap.hue.model.LoginUser;
import jp.co.worksap.hue.model.entity.AppData;
import jp.co.worksap.hue.model.entity.AppSts;
import jp.co.worksap.hue.model.entity.AppType;
import jp.co.worksap.hue.model.entity.DependencyMst;
import jp.co.worksap.hue.model.entity.ProjectType;
import jp.co.worksap.hue.model.entity.VersionNo;
import jp.co.worksap.hue.service.ApplyService;
import jp.co.worksap.hue.service.ConfigService;

@RestController
public class RestApiController {
	@Autowired
	private ApplyService applyService;
	@Autowired
	private ConfigService configService;

	@RequestMapping(value = "/appdata", method = RequestMethod.GET)
	@ResponseBody
	public List<AppData> getApplyingData(@AuthenticationPrincipal LoginUser user) {
		return applyService.getApplyingData();
	}

	@RequestMapping(value = "/appfindata", method = RequestMethod.GET)
	@ResponseBody
	public List<AppData> getCompletedData(@AuthenticationPrincipal LoginUser user) {
		return applyService.getCompletedData();
	}

	@RequestMapping(value = "/myappdata", method = RequestMethod.GET)
	@ResponseBody
	public List<AppData> getMyAppliedData(@AuthenticationPrincipal LoginUser user) {
		return applyService.getMyAppliedData(user.getUserId());
	}
	
	@RequestMapping(value="/apptype", method=RequestMethod.GET)
	@ResponseBody
	public List<AppType> getAppType(@AuthenticationPrincipal LoginUser user) {
		return configService.getAppType();
	}
	
	@RequestMapping(value="/version", method=RequestMethod.GET)
	@ResponseBody
	public List<VersionNo> getVersion(@AuthenticationPrincipal LoginUser user) {
		return configService.getVersionNo();
	}
	
	@RequestMapping(value="/prjtype", method=RequestMethod.GET)
	@ResponseBody
	public List<ProjectType> getPrjType(@AuthenticationPrincipal LoginUser user) {
		return configService.getProjectType();
	}
	
	@RequestMapping(value="/dependency", method=RequestMethod.GET)
	@ResponseBody
	public List<DependencyMst> getDependency(@AuthenticationPrincipal LoginUser user) {
		return configService.getDependencyMst();
	}
	
	@RequestMapping(value="/appsts", method=RequestMethod.GET)
	@ResponseBody
	public List<AppSts> getAppSts(@AuthenticationPrincipal LoginUser user) {
		return configService.getAppSts();
	}
	
	@RequestMapping(value="/apply/remove", method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<HttpStatus> remove(@AuthenticationPrincipal LoginUser user, @RequestBody Map<String, Object> params) {
		long appId = Long.parseLong(params.get("appId").toString());
		AppDetailDto dto = applyService.getApplyDtlData(appId);
		applyService.deleteApplyData(appId, dto.getAppData().getAppTypeCode());
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
