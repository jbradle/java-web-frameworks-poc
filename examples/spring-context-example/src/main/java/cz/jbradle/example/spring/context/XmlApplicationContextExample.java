package cz.jbradle.example.spring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplicationContextExample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/xmlContext.xml");

        ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");

        System.out.println(exampleBean.number);
        System.out.println(exampleBean.text);
    }
}
