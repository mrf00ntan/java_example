package kz.webdogovor.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String patronymic;

    private String phone;

    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_relationship", joinColumns = @JoinColumn(
            name = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id"))
    private SpravRole role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "controlUser")
    @JsonIgnore
    private Set<Member> members;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name="parent_user_relationship")
    private User parent;

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

    public SpravRole getRole() {
        return role;
    }

    public void setRole(SpravRole role) {
        this.role = role;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }
}
