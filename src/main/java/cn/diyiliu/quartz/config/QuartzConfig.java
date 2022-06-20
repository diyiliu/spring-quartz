package cn.diyiliu.quartz.config;

import cn.diyiliu.quartz.job.MyJob;
import cn.diyiliu.quartz.util.SpringUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * QuartzConfig
 * 配置项
 *
 * @author diyiliu
 * @create 2022-06-20 8:56
 **/

@Configuration
@ComponentScan("cn.diyiliu.quartz")
public class QuartzConfig {

    @Autowired
    private SchedulerFactoryBean schedulerFactory;

    @Bean
    public SpringUtil springUtil() {

        return new SpringUtil();
    }

    @Bean(initMethod = "start")
    public SchedulerFactoryBean scheduler(ApplicationContext applicationContext) {
        SpringBeanJobFactory springJobFactory = new SpringJobFactory(applicationContext);
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(springJobFactory);

        return factory;
    }

    @PostConstruct
    public void init() throws Exception {
        JobDetail job = JobBuilder.newJob().ofType(MyJob.class)
                .withIdentity("myJob")
                .build();


        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                .startAt(new Date(System.currentTimeMillis() + 10_000))
                .build();

        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(job, trigger);
    }
}
