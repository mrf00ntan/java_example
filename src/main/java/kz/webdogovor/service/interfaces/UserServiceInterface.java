package kz.webdogovor.service.interfaces;

import kz.webdogovor.model.SpravRole;
import kz.webdogovor.model.User;
import kz.webdogovor.pojo.UserPOJO;
import kz.webdogovor.pojo.UserWithFieldPOJO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface UserServiceInterface {
    User findByLogin(String login);
    User findById(Long id);
    User update(User user);
    Set<SpravRole> getRoles(Long id);
    User add(UserPOJO user, User parent);
    Integer getCountAllByParent(User user);
    Integer getCountAllByParentWithFilter(User user, String like);
    Page<UserWithFieldPOJO> findAllBySearchWithPageable(User user, String like, Pageable pageable);
}
