package spring.question;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import spring.quiz.Quiz;

import javax.persistence.*;

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)

@Entity
@Table(name="Question")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @Column
    private String text;
    @Column
    private String choice1;
    @Column
    private String choice2;
    @Column
    private String choice3;
    @Column
    private String choice4;
    @Column
    private int correct;
    @Column
    private int points;

    @ManyToOne
    @JoinColumn(name = "quiz")
    public Quiz quiz;

}