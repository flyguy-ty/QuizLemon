package spring.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}