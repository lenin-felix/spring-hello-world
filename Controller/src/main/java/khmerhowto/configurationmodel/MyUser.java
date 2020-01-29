package khmerhowto.configurationmodel;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import khmerhowto.Repository.Model.User;

/**
 * MyUser
 */
public class MyUser implements UserDetails {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final User user;
 
    public MyUser(final User user) {
        this.user = user;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "{noop}"+user.getPassword();
    }
    
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    
    public String getName(){
        return user.getName();
    }

    public User getCurrentUser(){
        return this.user;
    }
}