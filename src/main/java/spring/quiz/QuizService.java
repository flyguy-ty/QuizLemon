package spring.quiz;

import org.springframework.stereotype.Component;
import spring.player.Player;
import spring.player.PlayerRepository;


import java.util.List;
@Component
/*@Scope("prototype")
scopes:
singleton(default): a single bean of this component is instantiated, and reused,
like the singleton design pattern
prototype: a bean is generated every time this component is wire
session: a bean is generated for every session
request: a bean is generated for every http_request
global session: a bean is generated for the lifecycle of a global httpsession
websocket scope: a bean is generated for the lifecycle of a spring websocket (niche)
 */
public class QuizService {
    QuizRepository quizRepository;
    public QuizService(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }

    public List<Quiz> findAllQuiz(){
        return quizRepository.findAll();
    }

    public Quiz findQuizByTitle(String title){
        return quizRepository.findByTitle(title);
    }
    public Quiz saveQuiz(Quiz quiz){
        return quizRepository.save(quiz);
    }
    public List<Quiz> findAllQuizByID(int id){
        return quizRepository.findAllByid(id);
    }

    public List<Quiz> deleteQuizByID(int id) {
        return quizRepository.deleteByid(id);
    }
}