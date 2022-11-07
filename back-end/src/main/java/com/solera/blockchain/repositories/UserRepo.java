package com.solera.blockchain.repositories;

import com.solera.blockchain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    @Query(value = "SELECT distinct on id, email, password FROM Users WHERE email = :email AND password = :password ", nativeQuery = true)
    public User isLoggedIn(@Param("email") String email,
                      @Param("password") String password);
}
