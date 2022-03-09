package spring.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Question")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {
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


}