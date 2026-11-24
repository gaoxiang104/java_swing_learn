package org.xgo.swing_learn.z_demo.eventBusDemo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;


// 极简的事件总线
public class SimpleEventBus {
    private static final Map<Class<?>, List<Consumer<?>>> subscribers = new HashMap<>();
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    /**
     * 订阅指定类型的事件处理器
     *
     * @param <T>       事件类型泛型参数
     * @param eventType 要订阅的事件类型Class对象，用于标识事件类型
     * @param handler   事件处理器，当指定类型的事件发布时将被调用
     */
    public static <T> void subscribe(Class<T> eventType, Consumer<T> handler) {
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>())
                .add((Consumer<?>) handler);
    }

    /**
     * 发布事件到事件总线
     *
     * @param <T>   事件类型泛型参数
     * @param event 要发布的事件对象，不能为null
     */
    public static <T> void publish(T event) {
        List<Consumer<?>> handlers = subscribers.get(event.getClass());
        if (null != handlers) {
            for (Consumer<?> handler : handlers) {
                if (event instanceof UIEvent) {
                    SwingUtilities.invokeLater(() -> ((Consumer<T>) handler).accept(event));
                } else {
                    executor.execute(() -> ((Consumer<T>) handler).accept(event));
                }
            }
        }
    }

    /**
     * 关闭线程池执行器
     * <p>
     * 此方法用于优雅地关闭线程池，阻止新任务的提交，
     * 并等待已提交的任务执行完成后再关闭线程池。
     */
    public static void shutdown() {
        executor.shutdown();
    }


}
