package com.adam.test.authorization.vo;

import java.util.List;

/**
 * Created by Adam.Zhang on 2017/8/25.
 */
public class UserVo extends BaseVo {
    public String username;
    public boolean isEnabled;
    public String roleName;
    public List<String> authorities;
}
