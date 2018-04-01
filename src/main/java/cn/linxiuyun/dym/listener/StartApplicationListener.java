package cn.linxiuyun.dym.listener;

import cn.linxiuyun.dym.cache.CustomCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(StartApplicationListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        logger.info("初始化缓存...");

        CustomCache.init(4096);

        logger.info("初始化缓存完成...");
    }

}
