package cz.jbradle.example.spring.web.model;

public class ExampleEntity {

    private final Integer id;

    private final String value;

	public ExampleEntity(Integer id, String value) {
		this.id = id;
		this.value =  value;
	}

	public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "ExampleEntity{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}