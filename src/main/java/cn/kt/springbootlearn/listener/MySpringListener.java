package cn.kt.springbootlearn.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MySpringListener implements ApplicationListener<ContextRefreshedEvent> {

    /*@Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("监听到 已启动");
    }*/

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("监听到 已启动");

    }
}
