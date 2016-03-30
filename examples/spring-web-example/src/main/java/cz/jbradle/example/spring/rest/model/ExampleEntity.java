package cz.jbradle.example.spring.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EXAMPLE_ENTITY")
public class ExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ID_GENERATOR")
    @SequenceGenerator(name = "ID_GENERATOR", sequenceName = "SEQ_ID")
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "VALUE")
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String name) {
        this.value = name;
    }

    @Override
    public String toString() {
        return "ExampleEntity{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}