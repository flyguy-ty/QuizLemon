package spring.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.player.Player;

import javax.transaction.Transactional;
import java.util.List;

//transactional will wrap a method with a transaction manager that opens and closes
//a transaction like in hibernate
//we can also define a transaction strategy ourselves (on revpro)
@Transactional
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    /*JPQL is a subset of HQL:
    all JPQL are valid HQL statements
     */

    Question save(Question question);

    //@Query("from Digimon")
    List<Question> findAll();

    //@Query("from Digimon where name = :name")
    Question findByText(String question);
    @Query("from Question where id = :id")
    List<Question> findAllByid(int id);

    //@Query("from Question where id = :id")
    List<Question> deleteByid(int id);
}

/*
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DigimonRepository {
    List<Digimon> digimons;
    public DigimonRepository(){
        digimons = new ArrayList<Digimon>();
        digimons.add(new Digimon(0, "abc", 10));
        digimons.add(new Digimon(1, "def", 20));
        digimons.add(new Digimon(2, "hij", 30));
    }
    public List<Digimon> getAllDigimon(){
        return digimons;
    }
    public List<Digimon> findAllDigimonByName(String name){
        return digimons.stream().filter(digimon -> digimon.getName().equals(name)).collect(Collectors.toList());

    }
}*/