package com.adam.test.authorization.config;

import com.adam.test.authorization.model.Authority;
import com.adam.test.authorization.model.Client;
import com.adam.test.authorization.model.Role;
import com.adam.test.authorization.model.User;
import com.adam.test.authorization.repository.AuthorityRepository;
import com.adam.test.authorization.repository.ClientRepository;
import com.adam.test.authorization.repository.RoleRepository;
import com.adam.test.authorization.repository.UserRepository;
import com.adam.test.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Adam.Zhang on 2017/6/14.
 */
@Configuration
public class ApplicationConfigs {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public ApplicationConfigs(ClientRepository clientRepository, RoleRepository roleRepository, UserService userService, AuthorityRepository authorityRepository) {
        initClients(clientRepository);
        initAuthorities(authorityRepository);
        initRoles(roleRepository, authorityRepository);
        initUsers(userService, roleRepository);
    }

    private void initAuthorities(AuthorityRepository authorityRepository) {
        if (authorityRepository.count() == 0) {
            Authority authority = new Authority("MANAGE_STAFF");
            authorityRepository.save(authority);
        }
    }

    private void initClients(ClientRepository clientRepository) {
        List<Client> clients = clientRepository.findAll();
        if (clients == null || clients.isEmpty()) {
            Client client = new Client();
            client.clientId = "browser";

            HashSet<String> authorizedGrantTypes = new HashSet<>();
            authorizedGrantTypes.add("password");
            authorizedGrantTypes.add("refresh_token");
            client.authorizedGrantTypes = authorizedGrantTypes;

            HashSet<String> scopes = new HashSet<>();
            scopes.add("ui");
            client.scope = scopes;
            client.isScoped = true;

            client.authorities = new ArrayList<>();

            clientRepository.save(client);
        }
    }

    private void initRoles(RoleRepository roleRepository, AuthorityRepository authorityRepository) {
        if (roleRepository.count() == 0) {
            Role role = new Role();
            role.name = "admin";
            role.authorities = authorityRepository.findAll();
            roleRepository.save(role);
        }
    }

    private void initUsers(UserService userService, RoleRepository roleRepository) {
        if (userService.count() == 0) {
            User user = new User();
            user.username = "admin";
            user.password = "abc123_";
            user.isEnabled = true;
            user.roleId = roleRepository.findAll().get(0).id;
            userService.createUser(user);
        }
    }


}
