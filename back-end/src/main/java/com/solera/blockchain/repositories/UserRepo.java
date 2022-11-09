package com.solera.blockchain.repositories;

import com.solera.blockchain.models.Question;
import com.solera.blockchain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    @Query(value = "select * from users where users.email = :email", nativeQuery = true)
    public Optional<User> findByEmail(@Param("email") String email);

    @Query(value = "select (password = crypt(:password, " +
            "(select password from users u where u.email = :email))) as canLogin " +
            "from users where users.email = :email" ,nativeQuery = true)
    public boolean userCanLogin(@Param("email") String email, @Param("password") String password);

    @Modifying
    @Query(value = "insert into users(email, \"password\")" +
            "values(:email, crypt(:password, gen_salt('bf')))" +
            " returning id, email, password", nativeQuery = true)
    public User save(@Param("email") String email,
                     @Param("password") String password);


//    @Query(value = "select (password = crypt(:password, " +
//            " (select \"password\"" +
//            " from users " +
//            " where users.email = :email)" +
//            " )) as pswmatch " +
//            " from users" +
//            " limit 1", nativeQuery = true)
//
//    public Optional<Boolean> exists(@Param("email") String email,
//                                    @Param("password") String password);

//    @Query(value = "select\n" +
//            "case\n" +
//            "\twhen sub1.pswmatch = true then true\n" +
//            "    else false\n" +
//            "end\n" +
//            "from (select (password = crypt(:password, \n" +
//            "            (select \"password\"\n" +
//            "             from users\n" +
//            "             where users.email = :email) \n" +
//            "             )) as pswmatch\n" +
//            "             from users where users.email = :email) sub1", nativeQuery = true)
//    public Optional<Boolean> hasNotAnswered(@Param("email") String email,
//                                            @Param("password") String password);
}
