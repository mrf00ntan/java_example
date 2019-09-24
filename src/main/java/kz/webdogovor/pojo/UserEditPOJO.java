package kz.webdogovor.pojo;

import kz.webdogovor.model.SpravRole;

import java.util.Set;

public class UserEditPOJO {

    private Long userId;

    private String login;

    private String password;

    private String name;

    private String surname;

    private String patronymic;

    private String phone;

    private String email;

    private Long parent;

    private SpravRole currentRole;

    private Set<SpravRole> enabledRoles;

    public UserEditPOJO(Long userId, String login, String password, String name, String surname, String patronymic, String phone, String email, Set<SpravRole> enabledRoles, Long parent, SpravRole currentRole){
        this.userId = userId;
        this.password = password;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.enabledRoles = enabledRoles;
        this.parent = parent;
        this.currentRole = currentRole;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<SpravRole> getEnabledRoles() {
        return enabledRoles;
    }

    public void setEnabledRoles(Set<SpravRole> enabledRoles) {
        this.enabledRoles = enabledRoles;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public SpravRole getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(SpravRole currentRole) {
        this.currentRole = currentRole;
    }
}
