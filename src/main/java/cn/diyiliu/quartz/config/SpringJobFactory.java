package cn.diyiliu.quartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * SpringJobFactory
 *
 * @author diyiliu
 * @create 2022-06-20 11:36
 **/

public class SpringJobFactory extends SpringBeanJobFactory  {

    private final ApplicationContext applicationContext;

    public SpringJobFactory(ApplicationContext applicationContext) {

        this.applicationContext = applicationContext;
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(job);

        return job;
    }
}
