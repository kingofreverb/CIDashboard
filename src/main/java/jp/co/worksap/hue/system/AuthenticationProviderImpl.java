package jp.co.worksap.hue.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import jp.co.worksap.hue.model.LoginUser;
import jp.co.worksap.hue.model.dao.WapUserDao;
import jp.co.worksap.hue.model.entity.WapUser;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {
	@Autowired
	private WapUserDao wapUserDao;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String userId = auth.getName();
		if ("".equals(userId)) {
			throw new AuthenticationCredentialsNotFoundException("ユーザーID（Eメールアドレス）が間違っています");
		}
		WapUser user = wapUserDao.getUser(userId);
		if (user == null) {
			throw new AuthenticationCredentialsNotFoundException("ユーザーID（Eメールアドレス）が登録されていません");
		}
		return new UsernamePasswordAuthenticationToken(new LoginUser(user), null, auth.getAuthorities());
	}
	
	@Override
	public boolean supports(Class<?> token) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(token);
	}
}
