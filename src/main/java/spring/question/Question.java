package spring.question;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import spring.quiz.Quiz;

import javax.persistence.*;

@Entity
@Table(name="Question")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {
//    Foreign key is quiz_id. How do this?
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
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnoreProperties(value = "question")
    public Quiz quiz;

}