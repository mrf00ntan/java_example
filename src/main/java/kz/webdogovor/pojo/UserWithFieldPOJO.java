package kz.webdogovor.pojo;

public class UserWithFieldPOJO {
    private Long userId;
    private String surname;
    private String name;
    private String patronymic;
    private String login;
    private String password;

    public UserWithFieldPOJO(Long userId, String surname, String name, String patronymic, String login, String password) {
        this.userId = userId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
}
