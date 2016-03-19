package cz.jbradle.poc.web.spring.app.mapping;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * A mapper bean designed for Spring, suitable for dependency injection.
 * <p>
 * Provides an implementation of {@link ma.glasnost.orika.MapperFacade} which can be injected.  In addition it
 * is {@link ApplicationContextAware} so it sets application context as private variable. Then as
 * {@link InitializingBean} after properties are set runs method, in that it can auto-discover any implementations
 * of {@link Mapper} or {@link Converter} and register them into mapper factory.
 * <p>
 * Created by JBradle on 25.11.2015.
 */
public class ContextAwareMapperBean extends ConfigurableMapper implements ApplicationContextAware, InitializingBean {

    private MapperFactory factory;

    private ApplicationContext applicationContext;

    @Override
    protected void configure(final MapperFactory factory) {
        this.factory = factory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        addAllSpringBeans();
    }

    /**
     * Adds all managed beans of type {@link Mapper} or {@link Converter} to the parent {@link MapperFactory}.
     */
    private void addAllSpringBeans() {
        final Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
        converters.values().forEach(this::addConverter);

        final Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
        mappers.values().forEach(this::addMapper);
    }

    /**
     * Add a {@link Converter}.
     *
     * @param converter The converter.
     */
    public void addConverter(final Converter<?, ?> converter) {
        factory.getConverterFactory().registerConverter(converter);
    }

    /**
     * Add a {@link Mapper}.
     *
     * @param mapper The mapper.
     */
    @SuppressWarnings("unchecked")
    public void addMapper(final Mapper<?, ?> mapper) {
        factory.classMap(mapper.getAType(), mapper.getBType())
                .byDefault()
                .customize((Mapper) mapper)
                .register();
    }
}