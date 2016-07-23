package jp.co.worksap.hue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.worksap.hue.model.UserFormDto;
import jp.co.worksap.hue.model.dao.WapUserDao;

@Service
public class AccountService {
	@Autowired
	private WapUserDao wapUserDao;
	
	public long regist(UserFormDto dto) {
		return wapUserDao.regist(dto);
	}
}
