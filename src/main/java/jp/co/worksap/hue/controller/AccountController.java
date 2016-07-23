package jp.co.worksap.hue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.worksap.hue.model.UserFormDto;
import jp.co.worksap.hue.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/account", method=RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("account");
	}
	
	@RequestMapping(value = "/account", method=RequestMethod.POST)
	public ModelAndView regist(@ModelAttribute UserFormDto dto) {
		long id = accountService.regist(dto);
		if (id < 0L) {
			return new ModelAndView("account");
		}
		return new ModelAndView("redirect:/login");
	}
}
