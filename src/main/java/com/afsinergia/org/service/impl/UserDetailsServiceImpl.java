package com.afsinergia.org.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afsinergia.org.model.UserStatus;
import com.afsinergia.org.model.UsutRol;
import com.afsinergia.org.model.UsutUsuario;
import com.afsinergia.org.service.UsutUsuarioService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


	@Autowired
	private UsutUsuarioService service;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UsutUsuario user = service.getUsuarioByUserName(username); //our own User model class
		
		if(user!=null){
			String password = user.getClave();
			//additional information on the security object
			boolean enabled = user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
			boolean credentialsNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonLocked = user.getStatus().equals(UserStatus.ACTIVE);
			
			//Let's populate user roles
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(UsutRol rol : user.getRoles()){
				authorities.add(new GrantedAuthorityImpl(rol.getNomRol()));
			}
			
			//Now let's create Spring Security User object
			org.springframework.security.core.userdetails.User securityUser = new 
					org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("User Not Found!!!");
		}
	}

}
