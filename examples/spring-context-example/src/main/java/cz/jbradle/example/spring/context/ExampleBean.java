package cz.jbradle.example.spring.context;

public class ExampleBean {

    int number;
    String text;

    public ExampleBean(int number) {
        this.number = number;
    }

    public void setText(String text) {
        this.text = text;
    }
}
