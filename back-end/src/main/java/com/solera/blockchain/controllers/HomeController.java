package com.solera.blockchain.controllers;


import com.solera.blockchain.models.Answer;
import com.solera.blockchain.models.Question;
import com.solera.blockchain.models.User;
import com.solera.blockchain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    AnswerRepo answerRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    UserRepo userRepo;

    public HomeController() {
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<User> login(@RequestBody User u) {
        User userFromDb = null;
        HttpStatus status = null;

        try {
            userFromDb = userRepo.exists(u.getEmail(), u.getPassword());
            if (userFromDb != null) {
                if (userRepo.hasNotAnswered(u.getEmail(), u.getPassword())) {
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
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(userFromDb, status);

    }

    @PostMapping("/{userId}/answers")
    @CrossOrigin
    public ResponseEntity<Object> addAnswer(@PathVariable UUID userId, @RequestBody Answer answerReques) {
//        Answer answer = userRepo.findById(userId).map(user -> {
//            user.addTag(tagRequest);
//            return
//        }).orElse(null);
        /*
        * Tag tag = tutorialRepository.findById(tutorialId).map(tutorial -> {
      long tagId = tagRequest.getId();

      // tag is existed
      if (tagId != 0L) {
        Tag _tag = tagRepository.findById(tagId)
            .orElseThrow(() -> new ResourceNotFoundException("Not found Tag with id = " + tagId));
        tutorial.addTag(_tag);
        tutorialRepository.save(tutorial);
        return _tag;
      }

      // add and create new Tag
      tutorial.addTag(tagRequest);
      return tagRepository.save(tagRequest);
    }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));

    return new ResponseEntity<>(tag, HttpStatus.CREATED);*/

        return new ResponseEntity<>("a", HttpStatus.OK);
    }

    @GetMapping("/questions")
    @CrossOrigin
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionRepo.findAll();

        return new ResponseEntity<>(questions, HttpStatus.OK);
//        HttpStatus status = null;
//        List<Question> questions = null;
//        try{
//            questions = questionRepo.findAll();
//            status = HttpStatus.OK;
//        } catch ( Exception e){
//            status = HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return new ResponseEntity<>(questions, status);
    }
}
