package com.solera.blockchain.repositories;

import com.solera.blockchain.models.User;
import com.solera.blockchain.models.UserAnswer;
import com.solera.blockchain.models.UserAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAnswerRepo extends JpaRepository<UserAnswer, UserAnswerId> {
    @Query(value = "select * from useranswer where useranswer.user_id = :userId", nativeQuery = true)
    public List<UserAnswer> getUserAnswersByUserId(@Param("userId") UUID userId);
}
