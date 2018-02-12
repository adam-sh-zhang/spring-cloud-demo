package com.adam.test.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Adam.Zhang on 2017/8/24.
 */
public class User extends BaseModel {
    public String username;
    public boolean isEnabled;
    public String roleName;
    public List<String> authorities;
}
