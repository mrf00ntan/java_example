package kz.webdogovor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sprav_roles")
public class SpravRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name="role_name", nullable = false, unique = true)
    private String roleName;

    @Column(name = "role_desc")
    private String roleDesc;

    @Column(name = "name_ru", nullable = false)
    private String nameRu;

    @Column(name = "name_kz", nullable = false)
    private String nameKz;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    @JsonIgnore
    private Set<User> users;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
