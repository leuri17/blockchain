package com.solera.blockchain.repositories;

import com.solera.blockchain.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionRepo extends JpaRepository<Question, UUID> {

}
