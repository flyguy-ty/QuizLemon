package spring.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Player")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private int power;
}