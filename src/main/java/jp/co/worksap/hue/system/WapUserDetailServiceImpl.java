package jp.co.worksap.hue.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.co.worksap.hue.model.LoginUser;
import jp.co.worksap.hue.model.dao.WapUserDao;
import jp.co.worksap.hue.model.entity.WapUser;

@Component
public class WapUserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private WapUserDao wapUserDao;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		WapUser user = wapUserDao.getUser(userId);
		if (user == null) {
            throw new UsernameNotFoundException("ユーザーID（Eメールアドレス）が登録されていません");
        }
		return new LoginUser(user);
	}
}
