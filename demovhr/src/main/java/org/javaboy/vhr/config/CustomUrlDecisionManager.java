package org.javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomUrlDecisionManager implements AccessDecisionManager{
    //Authentication当前登陆用户信息
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute:configAttributes){
            String needRole = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)){
                //当前用户是这个匿名用户的实例的话，说明你没有登陆
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登陆，请登陆！");
                }else {
                    return;
                }
            }
            //获取当前登陆用户的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                //当前用户的角色跟所需要的角色是否匹配
                if (authority.getAuthority().equals(needRole)){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
