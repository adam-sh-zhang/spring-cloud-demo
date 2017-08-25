package com.adam.test.util;

import com.adam.test.model.User;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Adam.Zhang on 2017/8/24.
 */
public class UserPrincipalExtractor implements PrincipalExtractor {
    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        User user = new User();

        if (map.containsKey("id")) {
            user.id = (String) map.get("id");
        }
        if (map.containsKey("username")) {
            user.username = ((String) map.get("username"));
        }

        if (map.containsKey("roleName")) {
            user.roleName = ((String) map.get("roleName"));
        }

        if (map.containsKey("createdDate")) {
            user.createdDate = new Date(((Long) map.get("createdDate")));
        }

        if (map.containsKey("updatedDate")) {
            user.updatedDate = new Date(((Long) map.get("updatedDate")));
        }

        if (map.containsKey("isEnabled")) {
            user.isEnabled = ((boolean) map.get("isEnabled"));
        }

        if (map.containsKey("authorities")) {
            user.authorities = ((List<String>) map.get("authorities"));
        }


        return user;
    }
}
