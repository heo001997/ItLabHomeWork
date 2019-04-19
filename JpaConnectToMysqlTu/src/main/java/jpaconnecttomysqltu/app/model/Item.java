package jpaconnecttomysqltu.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
@Entity
public class Item implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
