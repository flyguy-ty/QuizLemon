package spring.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
    @Column
    private int power;
}