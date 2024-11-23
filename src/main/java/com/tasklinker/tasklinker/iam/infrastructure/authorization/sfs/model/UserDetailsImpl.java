package com.tasklinker.tasklinker.iam.infrastructure.authorization.sfs.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tasklinker.tasklinker.iam.domain.model.aggregates.User;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * This class is responsible for providing the user details to the Spring
 * Security framework.
 * It implements the UserDetails interface.
 */
@Getter
@EqualsAndHashCode
public class UserDetailsImpl implements UserDetails {

    private final String username;
    @JsonIgnore
    private final String password;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    /**
     * This method is responsible for building the UserDetailsImpl object from the
     * User object.
     * 
     * @param user The user object.
     * @return The UserDetailsImpl object.
     */
    public static UserDetailsImpl build(User user) {
        Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserDetailsImpl(
                user.getEmail(),
                user.getPassword(),
                authorities);
    }
}