package com.adam.test.authorization.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Adam.Zhang on 2017/8/24.
 */
public class Authority extends BaseModel implements GrantedAuthority {

    public String name;

    public Authority(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
