package spring.question;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
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
public class QuestionService {
    QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public List<Question> findAllQuestion(){
        return questionRepository.findAll();
    }

    public Question findQuestionByText(String text){
        return questionRepository.findByText(text);
    }

    public Question saveQuestion(Question question){

        return questionRepository.save(question);
    }
    public List<Question> findAllQuestionByID(int id){
        return questionRepository.findAllByid(id);
    }

}