package jp.co.worksap.hue.controller;

import java.io.Serializable;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jp.co.worksap.hue.model.LoginUser;

@Controller
public class HomeController implements Serializable {
	private static final long serialVersionUID = 1L;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView home(@AuthenticationPrincipal LoginUser user) {
		ModelAndView model = new ModelAndView("home");
		model.addObject("user", user);
//		model.addObject("myApplyList", applyService.getMyAppliedData(user.getUserId()));
		return model;
	}
}
