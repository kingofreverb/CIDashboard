package jp.co.worksap.hue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.worksap.hue.model.AppDetailDto;
import jp.co.worksap.hue.model.AppUpdateDto;
import jp.co.worksap.hue.model.LoginUser;
import jp.co.worksap.hue.model.MsaFormDto;
import jp.co.worksap.hue.model.ProjectFormDto;
import jp.co.worksap.hue.service.ApplyService;
import jp.co.worksap.hue.service.ConfigService;

@Controller
public class DevelopController {
	@Autowired
	private ConfigService configService;
	@Autowired
	private ApplyService applyService;
	
	@RequestMapping(value="/project", method=RequestMethod.GET)
	public ModelAndView getPrj(@AuthenticationPrincipal LoginUser user) {
		ModelAndView model = new ModelAndView("project");
		model.addObject("user", user);
		model.addObject("appTypeCd", "app_prj");
		model.addObject("appTypeItems", configService.getAppType());
		model.addObject("versionItems", configService.getVersionNo());
		model.addObject("projectTypeItems", configService.getProjectType());
		model.addObject("dependencyItems", configService.getDependencyMst());
		return model;
	}
	
	@RequestMapping(value="/project", method=RequestMethod.POST)
	public ModelAndView postPrj(@AuthenticationPrincipal LoginUser user, @ModelAttribute ProjectFormDto data) {
		applyService.registPrjData(data);
		ModelAndView model = new ModelAndView("redirect:/home");
		model.addObject("user", user);
		model.addObject("myApplyList", applyService.getMyAppliedData(user.getUserId()));
		return model;
	}
	
	@RequestMapping(value="/msa", method=RequestMethod.GET)
	public ModelAndView getMsa(@AuthenticationPrincipal LoginUser user) {
		ModelAndView model = new ModelAndView("msa");
		model.addObject("user", user);
		model.addObject("appTypeCd", "app_msa");
		model.addObject("appTypeItems", configService.getAppType());
		model.addObject("versionItems", configService.getVersionNo());
		return model;
	}
	
	@RequestMapping(value="/msa", method=RequestMethod.POST)
	public ModelAndView postMsa(@AuthenticationPrincipal LoginUser user, @ModelAttribute MsaFormDto data) {
		applyService.registMsaData(data);
		ModelAndView model = new ModelAndView("redirect:/home");
		model.addObject("user", user);
		model.addObject("myApplyList", applyService.getMyAppliedData(user.getUserId()));
		return model;
	}
	
	@RequestMapping(value="/apply/{appId}", method=RequestMethod.GET)
	public ModelAndView getApplyDtl(@AuthenticationPrincipal LoginUser user, @PathVariable long appId) {
		AppDetailDto dto = applyService.getApplyDtlData(appId);
		ModelAndView model = new ModelAndView("applydetail");
		model.addObject("user", user);
		model.addObject("appData", dto.getAppData());
		model.addObject("prjReqData", dto.getPrjReqData());
		model.addObject("msaReqData", dto.getMsaReqData());
		model.addObject("appTypeItems", configService.getAppType());
		model.addObject("appStsItems", configService.getAppSts());
		model.addObject("versionItems", configService.getVersionNo());
		model.addObject("projectTypeItems", configService.getProjectType());
		model.addObject("dependencyItems", configService.getDependencyMst());
		return model;
	}
	
	@RequestMapping(value="/apply/{appId}", method=RequestMethod.POST)
	public ModelAndView postApplyDtl(@AuthenticationPrincipal LoginUser user, @PathVariable long appId, @ModelAttribute AppUpdateDto dto) {
		applyService.updateApplyData(appId, dto);
		ModelAndView model = new ModelAndView("home");
		model.addObject("user", user);
		return model;
	}
}
