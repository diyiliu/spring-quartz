package cn.diyiliu.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * MyJob
 * 测试
 *
 * @author diyiliu
 * @create 2022-06-20 11:18
 **/

@Slf4j
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {

        log.info("123");
    }
}
