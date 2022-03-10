package spring.score;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import spring.player.Player;
import spring.quiz.Quiz;

import javax.persistence.*;

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)

@Entity
@Table(name="Score")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Score {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="player")
    private Player player;


    @ManyToOne
    @JoinColumn(name="quiz")
    private Quiz quiz;

    @Column
    private int score;

}