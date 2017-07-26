package example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LoginAccount implements UserDetails {

    private final Integer userId;
    private final String username;
    private final String password;
    private final Collection<GrantedAuthority> authorities;

    public LoginAccount(Integer userId, String email, String passwordDigest, boolean isAdmin) {
        this.userId = userId;
        this.username = email;
        this.password = passwordDigest;

        if (isAdmin) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
            List<GrantedAuthority> l = new ArrayList<>();
            l.add(grantedAuthority);
            this.authorities = l;
        } else {
            this.authorities = null;
        }
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
