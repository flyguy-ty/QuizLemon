package spring.quiz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    @Id
    private int id;
    @Column
    private String title;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="quiz_id")
    @JsonIgnoreProperties(value="quiz")
    private List<Question> questions;
}