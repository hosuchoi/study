package com.lake.smartway.applicationListener;

import com.lake.smartway.SmartwayApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component  // SmartwayApplication에서 직접 등록 했기 때문에 빈등록 의미가 없음
public class StartingEventListener implements ApplicationListener<ApplicationStartingEvent> {  //ApplicationStartingEvent 는 Application Context가 만들어지기 전에 이벤트 발생

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("============ApplicationStartingEvent=================");
        System.out.println("Application is starting");
        System.out.println("============ApplicationStartingEvent=================");
    }
}
