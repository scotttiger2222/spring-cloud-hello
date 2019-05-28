package com.loiane.springcloudhello.authentication;



import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

import org.mariadb.jdbc.internal.com.send.InterfaceAuthSwitchSendResponsePacket;
import org.mariadb.jdbc.internal.io.input.PacketInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.loiane.springcloudhello.filters.authenticationfilter;

@Component
public class customauthenticationprovider implements AuthenticationProvider {
    
private	Logger	logger = LoggerFactory.getLogger(customauthenticationprovider.class);
	
	
    public Authentication authenticate(Authentication auth) 
      throws AuthenticationException {
    	logger.info("helloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        String username = auth.getName();
        String password = auth.getCredentials()
            .toString();
        
        
        logger.info("helloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo:{}:{}",auth.getName(),auth.getCredentials());
 
        if ("externaluser".equals(username) && "pass".equals(password)) {
            return new UsernamePasswordAuthenticationToken
              (username, password, Collections.emptyList());
        } else {
            throw new
            BadCredentialsException("External system authentication failed");
        }
    }
 
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

	
	public InterfaceAuthSwitchSendResponsePacket processAuthPlugin(PacketInputStream arg0, String arg1, String arg2,
			byte[] arg3, int arg4, String arg5) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	


	
}
