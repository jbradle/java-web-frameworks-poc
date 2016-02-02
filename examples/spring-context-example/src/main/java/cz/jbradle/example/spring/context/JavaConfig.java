package cz.jbradle.example.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean(name="exampleBean")
    public ExampleBean getExampleBean() {
        ExampleBean exampleBean = new ExampleBean(123);
        exampleBean.setText("Example Text");
        return exampleBean;
    }
}
