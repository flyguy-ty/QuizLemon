package spring.quiz;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import spring.question.Question;
import spring.score.Score;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)

@Entity
@Table(name="Quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Quiz {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @Column
    private String title;

    @OneToMany
    @JoinColumn(name="quiz")
    private List<Question> questions;

    @OneToMany
    @JoinColumn(name="quiz")
    private List<Score> scores;
}