package cz.jbradle.example.spring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApplicationContextExample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/annotationContext.xml");

        AnnotationExampleBean exampleBean = (AnnotationExampleBean) context.getBean("annotationExampleBean");

        System.out.println(exampleBean.number);
        System.out.println(exampleBean.text);
    }
}