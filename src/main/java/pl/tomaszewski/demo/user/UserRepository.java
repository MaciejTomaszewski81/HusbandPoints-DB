package pl.tomaszewski.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByNick(String nick);
    @Modifying
    @Query("delete from User u where u.nick = ?1")
    void deleteByNick(String nick);

}