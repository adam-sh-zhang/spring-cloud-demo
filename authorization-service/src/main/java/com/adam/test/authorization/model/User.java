package com.adam.test.authorization.model;

import com.adam.test.authorization.service.RoleService;
import com.adam.test.authorization.util.ApplicationUtil;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import java.util.Collection;

/**
 * Created by Adam.Zhang on 2017/6/6.
 */
@Document
public class User extends BaseModel implements UserDetails {

    Role roleEntity;

    public String username;
    public String password;
    public String roleId;
    public boolean isEnabled;


    private Role getRole() {
        if (roleEntity == null) {
            RoleService roleService = ApplicationUtil.getBean(RoleService.class);
            roleEntity = roleService.getRoleById(this.roleId);
            if (roleEntity == null) {
                throw new RuntimeException("invalid role");
            }
        }
        return roleEntity;
    }

    public String getRoleName() {
        return getRole().name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role role = getRole();
        if (role != null && role.authorities != null) {
            return role.authorities;
        }
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return this.isEnabled;
    }
}
