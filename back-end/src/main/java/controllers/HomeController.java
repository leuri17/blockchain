package controllers;


import com.solera.blockchain.models.User;
import com.solera.blockchain.repositories.AnswerQuestionUserRepo;
import com.solera.blockchain.repositories.AnswerRepo;
import com.solera.blockchain.repositories.QuestionRepo;
import com.solera.blockchain.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.function.EntityResponse;

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
    public ResponseEntity<User> login(@RequestBody User u){
        User userFromDb = null;
        HttpStatus status = null;

        try{
            userFromDb = userRepo.isLoggedIn(u.getEmail(), u.getPassword());
        } catch (Exception e){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(userFromDb, status);

    }


}
