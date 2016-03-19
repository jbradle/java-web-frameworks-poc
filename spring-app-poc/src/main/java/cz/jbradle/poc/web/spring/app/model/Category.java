package cz.jbradle.poc.web.spring.app.model;

import javax.persistence.*;

/**
 * Category entity object
 * <p>
 * Created by JBradle on 6.12.2015.
 */
@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID_GENERATOR")
    @SequenceGenerator(name = "CATEGORY_ID_GENERATOR", sequenceName = "SEQ_CATEGORY_ID")
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
