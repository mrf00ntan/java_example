package kz.webdogovor.pojo;

public class UserPOJO {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private String email;
    private String roles;

    public UserPOJO(String login, String password, String name, String surname, String patronymic, String phone, String email, String roles) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.roles = roles;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
