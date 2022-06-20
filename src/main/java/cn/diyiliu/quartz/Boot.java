package cn.diyiliu.quartz;

import cn.diyiliu.quartz.config.QuartzConfig;
import cn.diyiliu.quartz.util.SpringUtil;

/**
 * Boot
 * 启动入口
 *
 * @author diyiliu
 * @create 2022-06-20 8:54
 **/
public class Boot {

    public static void main(String[] args) {

        SpringUtil.init(QuartzConfig.class);
    }
}
