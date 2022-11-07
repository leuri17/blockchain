package com.solera.blockchain.repositories;

import com.solera.blockchain.models.AnswerQuestionUser;
import com.solera.blockchain.models.IdAnswerQuestionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerQuestionUserRepo extends JpaRepository<AnswerQuestionUser, IdAnswerQuestionUser> {
}
