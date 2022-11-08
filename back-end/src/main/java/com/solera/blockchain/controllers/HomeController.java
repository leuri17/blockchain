package com.solera.blockchain.controllers;


import com.solera.blockchain.models.AnswerUser;
import com.solera.blockchain.models.Question;
import com.solera.blockchain.models.User;
import com.solera.blockchain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    AnswerUserRepo answerUserRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    UserRepo userRepo;

    public HomeController() {
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<Object> login(@RequestBody User u) {
        User userFromDb = null;
        HttpStatus status = null;
        String message = "Something went wrong";

        try {
            Optional<User> user = userRepo.existsEmail(u.getEmail()); // ??????
            User userFinal = null;
            if(user.isPresent()){
                userFinal = user.get();
            }
            if (userFinal != null) {
                Optional<Boolean> hasNotAnswered = userRepo.hasNotAnswered(u.getEmail(), u.getPassword());
                boolean hasNotAnsweredFinal = false;

                if (hasNotAnswered.isPresent()) {
                    hasNotAnsweredFinal = hasNotAnswered.get(); // ??????
                }

                if(hasNotAnsweredFinal) {
                    status = HttpStatus.OK;
                    return new ResponseEntity<>(userFinal, status);
                } else {
                    // MOSTRAR ERROR -> CUESTIONARIO YA RESPONDIDO
                    message = "You can only answer the questionnaire once.";
                    status = HttpStatus.FORBIDDEN;
                    return new ResponseEntity<>(message, status);
                }

            } else {
                User newUser = userRepo.insertUser(u.getEmail(), u.getPassword());
                status = HttpStatus.CREATED;
                return new ResponseEntity<>(newUser, status);
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(message, status);
        }

    }

    @PostMapping("/answer")
    @CrossOrigin
    public ResponseEntity<Object> saveAnswer(@RequestBody AnswerUser answerUser) {
        AnswerUser savedAnswerUSer = answerUserRepo.save(answerUser);
        return new ResponseEntity<>(savedAnswerUSer, HttpStatus.CREATED);
    }

    @GetMapping("/questions")
    @CrossOrigin
    public ResponseEntity<Object> getAllQuestions() {

        HttpStatus status = null;
        //Default error
        String message = "Something went wrong";
        List<Question> questions = null;
        try{
            questions = questionRepo.findAll();
            status = HttpStatus.OK;
        } catch ( Exception e){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(message, status);
        }
        return new ResponseEntity<>(questions, status);
    }
}
