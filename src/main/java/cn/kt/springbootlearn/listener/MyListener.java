package cn.kt.springbootlearn.listener;

import cn.kt.springbootlearn.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener<MyEvent> {
    public void onApplicationEvent(MyEvent event){
        System.out.println(event.whatsWrong());
    }
}
