package com.adam.test.util;

import com.adam.test.model.User;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam.Zhang on 2017/8/24.
 */
public class UserPrincipalExtractor implements PrincipalExtractor {
    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        User user = new User();
        if (map.containsKey("principal")) {
            HashMap<String, Object> details = (HashMap<String, Object>) map.get("principal");
            if (details.containsKey("id")) {
                user.setId((String) details.get("id"));
            }
            if (details.containsKey("username")) {
                user.setUsername((String) details.get("username"));
            }

            if (details.containsKey("password")) {
                user.setPassword((String) details.get("password"));
            }

            if (details.containsKey("roles")) {
                List<String> roles = new ArrayList<>();
                user.setRoles(roles);
            }
        }
        return user;
    }
}
