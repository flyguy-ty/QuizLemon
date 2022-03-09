package spring.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("question")
//if we want to access our endpoints, this would change all to player/(whatever)
public class QuestionController {
    QuestionService questionService;
    //    inject a service into our controller
//    autowired: will automatically 'wire' (really think of this as selecting
//    the most appropriate bean to use from the IOC container)
    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }
    @GetMapping()
    public List<Question> getQuestion(){
        return questionService.findAllQuestion();
    }
    @GetMapping("text/{text}")
    public Question getQuestionByText(@PathVariable String text){
        return questionService.findQuestionByText(text);
    }
    @PostMapping("question")
    public Question postQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }
    @GetMapping("question_id/{question_id}")
    public List<Question> getQuestionByID(@PathVariable int id){
        return questionService.findAllQuestionByID(id);
    }
    /*you're likely to also need
    a delete mapping
    @DeleteMapping
    a patch mapping
    @PatchMapping
     */
}