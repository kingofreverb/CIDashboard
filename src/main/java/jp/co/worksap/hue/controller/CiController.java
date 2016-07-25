package jp.co.worksap.hue.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jp.co.worksap.hue.model.LoginUser;

@Controller
public class CiController {

	@RequestMapping(value = "/progress", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView progress(@AuthenticationPrincipal LoginUser user) {
		ModelAndView model = new ModelAndView("ci-view");
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "/complete", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView complete(@AuthenticationPrincipal LoginUser user) {
		ModelAndView model = new ModelAndView("ci-view");
		model.addObject("user", user);
		return model;
	}
}
