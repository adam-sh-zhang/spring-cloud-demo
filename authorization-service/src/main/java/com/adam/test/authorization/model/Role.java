package com.adam.test.authorization.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Adam.Zhang on 2017/8/24.
 */
@Document
public class Role extends BaseModel {
    public String name;
    public List<Authority> authorities;
}
