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
@Table(name = "itemcategory")
@Entity
public class ItemCategory implements Serializable {
    @Id
    @Column(name = "item_Id")
    private int itemId;

    @Column(name = "category_Id")
    private int categoryId;
}
