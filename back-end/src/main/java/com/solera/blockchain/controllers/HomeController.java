package com.solera.blockchain.controllers;


import com.solera.blockchain.models.Question;
import com.solera.blockchain.models.User;
import com.solera.blockchain.repositories.AnswerRepo;
import com.solera.blockchain.repositories.QuestionRepo;
import com.solera.blockchain.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AnswerRepo answerRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    AnswerQuestionUserRepo aquRepo;

    public HomeController(){}

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<User> login(@RequestBody User u){
        User userFromDb = null;
        HttpStatus status = null;

        try{
            userFromDb = userRepo.exists(u.getEmail(), u.getPassword());
            if(userFromDb != null){
                if(userRepo.hasNotAnswered(u.getEmail(), u.getPassword())){
                    //MOSTRAR LAS PREGUNTAS
                } else {
                    // MOSTRAR ERROR -> CUESTIONARIO YA RESPONDIDO
                    status = HttpStatus.FORBIDDEN;
                }
            } else {
                // REGISTRAR USUARIO
                // MOSTRAR PREGUNTAS
            }
            status = HttpStatus.OK;
        } catch (Exception e){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(userFromDb, status);

    }

    @GetMapping("/questions")
    @CrossOrigin
    public ResponseEntity<List<Question>> getAllQuestions(){
        HttpStatus status = null;
        List<Question> questions = null;
        try{
            questions = questionRepo.findAll();
            status = HttpStatus.OK;
        } catch ( Exception e){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(questions, status);
    }


}
