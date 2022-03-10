package spring.player;

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
public class PlayerService {
    PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> findAllPlayer(){
        return playerRepository.findAll();
    }

    public Player findPlayerByName(String name){
        return playerRepository.findByName(name);
    }
    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }
    public List<Player> findAllPlayerByPower(int power){
        return playerRepository.findAllByPower(power);
    }

    public List<Player> deleteByid(int id) {
        return playerRepository.deleteByid(id);
    }
}