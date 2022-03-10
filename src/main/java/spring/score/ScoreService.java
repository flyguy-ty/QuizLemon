package spring.score;

import org.springframework.stereotype.Component;
import spring.player.Player;
import spring.quiz.Quiz;

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
public class ScoreService {
    ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository){
        this.scoreRepository = scoreRepository;
    }

    public List<Score> findAllScore(){
        return scoreRepository.findAll();
    }

    public Score saveScore(Score score){
        return scoreRepository.save(score);
    }

    public Score findByid(int id) {
        return scoreRepository.findByid(id);
    }

    public List<Score> deleteByid(int id) {
        return scoreRepository.deleteByid(id);
    }

    public List<Score> findAllQuizScore(Quiz quiz) {
        return scoreRepository.findByQuiz(quiz);
    }

    public List<Score> findAllPlayerScore(Player player) {
        return scoreRepository.findByPlayer(player);
    }

}