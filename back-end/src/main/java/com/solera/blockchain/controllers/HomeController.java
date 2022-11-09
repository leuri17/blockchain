package com.solera.blockchain.controllers;


import com.solera.blockchain.models.Answer;
import com.solera.blockchain.models.UserAnswer;
import com.solera.blockchain.models.Question;
import com.solera.blockchain.models.User;
import com.solera.blockchain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    UserAnswerRepo userAnswerRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    AnswerRepo answerRepo;

    public HomeController() {
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<Object> login(@RequestBody User userReq) {
        // Find User
        Optional<User> userOptional = userRepo.findByEmail(userReq.getEmail());
        try {
            if (userOptional.isPresent()) {
                // If user exists
                User user = userOptional.get();

                if (userAnswerRepo.getUserAnswersByUserId(user.getId()).size() != 0) {
                    // If user have answered the questionnaire
                    return new ResponseEntity<>("This user have answered the questionnaire. You can only answer once", HttpStatus.FORBIDDEN);
                } else {
                    // If user have answered the questionnaire
                    if (userRepo.userCanLogin(userReq.getEmail(), userReq.getPassword())) {
                        // If the password is correct
                        return new ResponseEntity<>(user, HttpStatus.OK);
                    } else {
                        // If the password is not correct
                        return new ResponseEntity<>("User or password incorrect", HttpStatus.UNAUTHORIZED);
                    }
                }
            } else {
                // If user does not exist
                User saveUser = userRepo.save(userReq.getEmail(), userReq.getPassword());
                return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{user_id}/answer")
    @CrossOrigin
    public ResponseEntity<Object> saveAnswer(@PathVariable String user_id, @RequestBody UUID answer_id) {
        try {
            // Find the user
            Optional<User> user = userRepo.findById(UUID.fromString(user_id));

            // Find the answer
            Optional<Answer> answer = answerRepo.findById(answer_id);

            // Create the AnswerUser object
            if (user.isPresent() && answer.isPresent()) {
                UserAnswer userAnswer = new UserAnswer(user.get(), answer.get());

                UserAnswer savedAnswer = userAnswerRepo.save(userAnswer);
                return new ResponseEntity<>(savedAnswer, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(new InstanceNotFoundException("The user or de answer does not exist"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/questions")
    @CrossOrigin
    public ResponseEntity<Object> getAllQuestions() {

        HttpStatus status = null;
        //Default error
        String message = "Something went wrong";
        List<Question> questions = null;
        try {
            questions = questionRepo.findAll();
            status = HttpStatus.OK;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(message, status);
        }
        return new ResponseEntity<>(questions, status);
    }
}
