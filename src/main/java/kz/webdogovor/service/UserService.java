package kz.webdogovor.service;

import kz.webdogovor.model.SpravRole;
import kz.webdogovor.model.User;
import kz.webdogovor.pojo.UserPOJO;
import kz.webdogovor.pojo.UserWithFieldPOJO;
import kz.webdogovor.repository.RoleRepository;
import kz.webdogovor.repository.UserRepository;
import kz.webdogovor.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public User update(User user) {
        User currentUser = findById(user.getUserId());
        currentUser.setEmail(user.getEmail());
        currentUser.setSurname(user.getSurname());
        currentUser.setName(user.getName());
        currentUser.setPatronymic(user.getPatronymic());
        currentUser.setLogin(user.getLogin());
        currentUser.setPassword(user.getPassword());
        currentUser.setPhone(user.getPhone());
        userRepository.save(currentUser);
        return currentUser;
    }

    @Override
    public Set<SpravRole> getRoles(Long id) {
        return roleRepository.findAllByRoleIdIsGreaterThan(id);
    }

    @Override
    @Transactional
    public User add(UserPOJO user, User parent) {
        User currentUser = new User();
        SpravRole spravRole = roleRepository.findSpravRoleByRoleId(Long.parseLong(user.getRoles()));

        currentUser.setEmail(user.getEmail());
        currentUser.setSurname(user.getSurname());
        currentUser.setName(user.getName());
        currentUser.setPatronymic(user.getPatronymic());
        currentUser.setLogin(user.getLogin());
        currentUser.setPassword(user.getPassword());
        currentUser.setPhone(user.getPhone());
        currentUser.setParent(parent);
        currentUser.setRole(spravRole);

        userRepository.save(currentUser);
        return currentUser;
    }

    @Override
    public Integer getCountAllByParent(User user) {
        return userRepository.countAllByParent(user);
    }

    @Override
    public Integer getCountAllByParentWithFilter(User user, String like) {
        return userRepository.countAllByParentUserWithFilter(user, like);
    }

    @Override
    public Page<UserWithFieldPOJO> findAllBySearchWithPageable(User user, String like, Pageable pageable) {
        return userRepository.findAllBySearchWithPageable(user, like, pageable);
    }
}
