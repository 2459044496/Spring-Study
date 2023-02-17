package cn.cuiper.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener {

    private String msg = "";

    public MyApplicationListener() {

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MyApplicationListener(String msg) {
        this.msg = msg;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("接收到事件:" + event.toString());
    }

    @EventListener(classes = {MyApplicationListener.class})
    public void listener(MyApplicationListener listener) {
        System.out.println("======收到MyApplicationListener事件:" + listener);
        System.out.println("======MyApplicationListener msg is :" + listener.getMsg());
    }
}
