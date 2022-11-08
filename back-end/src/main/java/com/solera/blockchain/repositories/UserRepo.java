package com.solera.blockchain.repositories;

import com.solera.blockchain.models.Question;
import com.solera.blockchain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    @Query(value = "select (password = crypt(:password,\n" +
            " (select \"password\" \n" +
            " from users " +
            " where users.email = :email)" +
            " )) as pswmatch " +
            " from users", nativeQuery = true)
    public boolean exists(@Param("email") String email,
                      @Param("password") String password);

    @Query(value = "select * from useranswer ua" +
            "where exists" +
            "(select email, \"password\"" +
            "from users u" +
            "where (u.email = :email))", nativeQuery = true)
    public boolean hasNotAnswered(@Param("email") String email);
}
