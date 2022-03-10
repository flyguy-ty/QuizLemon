package spring.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.question.Question;

import java.util.List;


@RestController
@RequestMapping("quiz")
//if we want to access our endpoints, this would change all to player/(whatever)
public class QuizController {
    QuizService quizService;
    //    inject a service into our controller
//    autowired: will automatically 'wire' (really think of this as selecting
//    the most appropriate bean to use from the IOC container)
    @Autowired
    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }
    @GetMapping("quiz")
    public List<Quiz> getQuiz(){
        return quizService.findAllQuiz();
    }
    @GetMapping("title/{title}")
    public Quiz getQuizByTitle(@PathVariable String title){
        return quizService.findQuizByTitle(title);
    }
    @PostMapping("quiz")
    public Quiz postQuiz(@RequestBody Quiz quiz){
        return quizService.saveQuiz(quiz);
    }
    @GetMapping("quiz_id/{quiz_id}")
    public List<Quiz> getQuizByID(@PathVariable int id){
        return quizService.findAllQuizByID(id);
    }
    @DeleteMapping("delete/{id}")
    public List<Quiz> deleteQuestionbyID(@PathVariable int id){
        return quizService.deleteQuizByID(id);
    }
    /*you're likely to also need
    a delete mapping
    @DeleteMapping
    a patch mapping
    @PatchMapping
     */
}