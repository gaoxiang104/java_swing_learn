package org.xgo.swing_learn.z_demo.eventBusDemo;

import java.util.Date;

/**
 * 业务协调器（核心逻辑） - 处理业务逻辑，连接各个组件
 */
public class AppCoordinator {
    public AppCoordinator() {
        setupEventCoordination();
    }

    /**
     * 设置事件协调机制
     * <p>
     * 该方法用于初始化和配置事件协调相关的组件和监听器，
     * 确保系统中各个事件能够正确地协同工作和响应。
     */
    private void setupEventCoordination() {
        SimpleEventBus.subscribe(AppEvents.ButtonClickEvent.class, event -> {
            System.out.println("协调器处理Button点击: " + event);

            // 执行业务逻辑
            StringBuffer newText = new StringBuffer("Button被点击！来源：").append(event.source);
            newText.append(" | 文本：").append(event.buttonText);
            newText.append(" | 时间：").append(new Date());

            // 发布标签更新事件
            AppEvents.LabelUpdateRequestEvent updateEvent =
                    new AppEvents.LabelUpdateRequestEvent(
                            "PanelB_Label",
                            newText.toString(),
                            "Coordinator");

            SimpleEventBus.publish(updateEvent);
        });

        SimpleEventBus.subscribe(AppEvents.LabelUpdateRequestEvent.class, event -> {
            System.out.println("协调器监控到标签更新: " + event);
        });
    }


}
