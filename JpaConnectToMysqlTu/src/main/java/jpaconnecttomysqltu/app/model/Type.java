package jpaconnecttomysqltu.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "type")
@Entity
public class Type implements Serializable{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}

