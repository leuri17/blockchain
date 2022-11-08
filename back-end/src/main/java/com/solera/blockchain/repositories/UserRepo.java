package com.solera.blockchain.repositories;

import com.solera.blockchain.models.Question;
import com.solera.blockchain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    @Query(value = "select (password = crypt(:password, " +
            " (select \"password\"" +
            " from users " +
            " where users.email = :email)" +
            " )) as pswmatch " +
            " from users" +
            " limit 1", nativeQuery = true)
    public Optional<Boolean> exists(@Param("email") String email,
                                    @Param("password") String password);

    @Query(value = "select * from users u where u.email = :email ", nativeQuery = true)
    public Optional<Boolean> existsEmail(@Param("email") String email);

    @Query(value = "select " +
            "case " +
            " when sub1.pswmatch = true then true" +
            "    else false" +
            "end " +
            "from (select (password = crypt(:password, " +
            "            (select \"password\"" +
            "             from users" +
            "             where users.email = :email) " +
            "             )) as pswmatch" +
            "             from users) sub1", nativeQuery = true)
    public boolean hasNotAnswered(@Param("email") String email);

    @Query(value = "insert into users(email, \"password\")" +
            "values(:email, crypt(:password, gen_salt('bf')))" +
            " returning id, email, password", nativeQuery = true)
    public User insertUser(@Param("email") String email,
                           @Param("password") String password);
}
