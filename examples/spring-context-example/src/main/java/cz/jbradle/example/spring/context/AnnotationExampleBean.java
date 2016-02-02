package cz.jbradle.example.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnotationExampleBean {

    int number;

    @Autowired
    String text;

    @Autowired
    public AnnotationExampleBean(int number) {
        this.number = number;
    }
}
