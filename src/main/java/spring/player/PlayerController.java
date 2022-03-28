package spring.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("player")
//if we want to access our endpoints, this would change all to player/(whatever)
public class PlayerController {
    PlayerService playerService;
    //    inject a service into our controller
//    autowired: will automatically 'wire' (really think of this as selecting
//    the most appropriate bean to use from the IOC container)
    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }
    @GetMapping("get")
    public List<Player> getPlayer(){
        return playerService.findAllPlayer();
    }
    @GetMapping("name/{name}")
    public Player getPlayerByName(@PathVariable String name){
        return playerService.findPlayerByName(name);
    }
    @PostMapping("post")
    public Player postPlayer(@RequestBody Player player){
        return playerService.savePlayer(player);
    }
   /* @GetMapping("power/{pow}")
    public List<Player> getPlayerByPower(@PathVariable int pow){
        return playerService.findAllPlayerByPower(pow);
    }

    */
    @DeleteMapping("delete/{id}")
    public List<Player> deletePlayerByID(@PathVariable int id){
        return playerService.deleteByid(id);
    }
    /*you're likely to also need
    a delete mapping
    @DeleteMapping
    a patch mapping
    @PatchMapping
     */
}