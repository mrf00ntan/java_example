package kz.webdogovor.config.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SelfUserPrincipal extends User {
    private final kz.webdogovor.model.User userObj;

    public SelfUserPrincipal(kz.webdogovor.model.User user) {
        super(user.getLogin(), user.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(user.getRole().getRoleName())));
        this.userObj = user;
    }

    public kz.webdogovor.model.User getUserObj() {
        return this.userObj;
    }
}
