package cz.jbradle.example.spring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigApplicationContextExample {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");

        System.out.println(exampleBean.number);
        System.out.println(exampleBean.text);
    }
}
