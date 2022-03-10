package spring.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.player.Player;
import spring.quiz.Quiz;


import java.util.List;


@RestController
@RequestMapping("score")
//if we want to access our endpoints, this would change all to player/(whatever)
public class ScoreController {
    ScoreService scoreService;
    //    inject a service into our controller
//    autowired: will automatically 'wire' (really think of this as selecting
//    the most appropriate bean to use from the IOC container)
    @Autowired
    public ScoreController(ScoreService scoreService){
        this.scoreService = scoreService;
    }
    @GetMapping("get")
    public List<Score> getScore(){
        return scoreService.findAllScore();
    }
    @GetMapping("id/{id}")
    public Score getQuizByID(@PathVariable int id){
        return scoreService.findByid(id);
    }
    @GetMapping("quiz/{quiz}")
    public List<Score> getAllQuizScore(@PathVariable Quiz quiz){
        return scoreService.findAllQuizScore(quiz);
    }
    @GetMapping("player/{player}")
    public List<Score> getAllQuizPlayer(@PathVariable Player player){
        return scoreService.findAllPlayerScore(player);
    }
    @PostMapping("post")
    public Score postScore(@RequestBody Score score){
        return scoreService.saveScore(score);
    }

    @DeleteMapping("delete/{id}")
    public List<Score> deleteScoreByID(@PathVariable int id){
        return scoreService.deleteByid(id);
    }

}