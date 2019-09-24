package kz.webdogovor.config.web;

import kz.webdogovor.model.User;
import kz.webdogovor.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SelfUserDetailsService implements UserDetailsService {
    @Autowired
    private UserServiceInterface userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);

        if (user == null)
            throw new UsernameNotFoundException("Login" + login + " not found");

        return new SelfUserPrincipal(user);
    }
}
