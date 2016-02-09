package cz.jbradle.example.spring.web.model;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GENERATOR")
	@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "SEQ_ID")
	@Column(name = "ID", unique = true, nullable = false)
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
		return "ExampleEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
