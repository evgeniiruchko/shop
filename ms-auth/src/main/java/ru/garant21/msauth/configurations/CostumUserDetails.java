package ru.garant21.msauth.configurations;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.garant21.msauth.enteties.Role;
import ru.garant21.msauth.enteties.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CostumUserDetails implements UserDetails {
    private String userName;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CostumUserDetails fromUserEntityToCostumUserDetailes(User user) {
        CostumUserDetails costumUserDetails = new CostumUserDetails();
        costumUserDetails.userName = user.getUsername();
        costumUserDetails.password = user.getPassword();
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        }
        costumUserDetails.grantedAuthorities = authorityList;
        return costumUserDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
