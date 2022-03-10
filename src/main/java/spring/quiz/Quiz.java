package spring.quiz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import spring.question.Question;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="quiz_id")
    @JsonIgnoreProperties(value="quiz")
    private List<Question> questions;
}