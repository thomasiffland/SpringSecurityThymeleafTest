package de.tiffland.services;

import de.tiffland.entities.User;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Thomas on 01.02.16.
 */
public class MyUserDetails implements UserDetails {


    private static final long serialVersionUID = 1L;

    private User user;

    private List<SimpleGrantedAuthority> auhorities = new LinkedList<>();

    public MyUserDetails(User user) {
        super();
        this.user = user;
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
