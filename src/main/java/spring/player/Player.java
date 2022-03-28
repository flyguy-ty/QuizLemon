package spring.player;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import spring.score.Score;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)

@Entity
@Table(name="Player")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String password;
   /*@Column
    private int power;

    */

    @OneToMany
    @JoinColumn(name="player")
    private List<Score> score;
}