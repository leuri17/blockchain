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

    @Query(value = "SELECT id, email, password FROM Users WHERE email = :email AND coalesce(crypt(:password, gen_salt('bf'), null)) = password ", nativeQuery = true)
    public User exists(@Param("email") String email,
                      @Param("password") String password);

    @Query(value = "select exists (select * from answersquestionsusers" +
            "inner join" +
            " (select * from users u where u.email = :email and u.password = crypt(:password, gen_salt('bf'))) sub1" +
            " on sub1.id = id); ", nativeQuery = true)
    public boolean hasNotAnswered(@Param("email") String email,
                             @Param("password") String password);
}
