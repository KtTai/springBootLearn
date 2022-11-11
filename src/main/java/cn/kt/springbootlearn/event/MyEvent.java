package cn.kt.springbootlearn.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

public class MyEvent extends ApplicationContextEvent {

    int something = 0;
    public MyEvent(ApplicationContext applicationContext,int something){
        super(applicationContext);
        this.something = something;
    }
    public String whatsWrong(){
        if (something == 1) {
            System.out.println("发生事件了");
            System.out.println("发射导弹");
            return "missile";
        } else {
            System.out.println("发生事件了");
            System.out.println("发射核导弹");
            return "fuck missile";
        }
    }
}
