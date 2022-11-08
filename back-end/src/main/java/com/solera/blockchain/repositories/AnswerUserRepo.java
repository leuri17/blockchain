package com.solera.blockchain.repositories;

import com.solera.blockchain.models.AnswerUser;
import com.solera.blockchain.models.AnswerUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerUserRepo extends JpaRepository<AnswerUser, AnswerUserId> {
}
