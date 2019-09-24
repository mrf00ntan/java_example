package kz.webdogovor.repository;

import kz.webdogovor.model.User;
import kz.webdogovor.pojo.UserWithFieldPOJO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    Integer countAllByParent(User user);

    @Query("SELECT count(u) FROM User u WHERE " +
            "u.parent = :parent AND u.surname LIKE %:likeString% " +
            "OR u.parent = :parent AND u.name LIKE %:likeString% " +
            "OR u.parent = :parent AND u.patronymic LIKE %:likeString% " +
            "OR u.parent = :parent AND u.login LIKE %:likeString% " +
            "OR u.parent = :parent AND u.password LIKE %:likeString%")
    Integer countAllByParentUserWithFilter(@Param("parent") User user, @Param("likeString") String like);

    @Query("SELECT new kz.webdogovor.pojo.UserWithFieldPOJO(u.userId, u.surname, u.name, u.patronymic, u.login, u.password) FROM User u WHERE " +
            "u.parent = :parent AND u.surname LIKE %:likeString% " +
            "OR u.parent = :parent AND u.name LIKE %:likeString% " +
            "OR u.parent = :parent AND u.patronymic LIKE %:likeString% " +
            "OR u.parent = :parent AND u.login LIKE %:likeString% " +
            "OR u.parent = :parent AND u.password LIKE %:likeString%")
    Page<UserWithFieldPOJO> findAllBySearchWithPageable(@Param("parent") User user, @Param("likeString") String likeString, Pageable pageable);
}
