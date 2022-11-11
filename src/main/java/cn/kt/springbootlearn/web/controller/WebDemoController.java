package cn.kt.springbootlearn.web.controller;

import cn.kt.springbootlearn.event.MyEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class WebDemoController implements ApplicationContextAware {

    ApplicationContext applicationContext;
    @RequestMapping("/fasd")
    public String demo1(){
        return "hello";
    }

    @RequestMapping("/fire")
    public String demo2(){
        applicationContext.publishEvent(new MyEvent(applicationContext,2));
        return "hello";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}
