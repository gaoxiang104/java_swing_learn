package org.xgo.swing_learn.z_demo.eventBusDemo;

/**
 * App所有事件定义
 */
public class AppEvents {

    /**
     * 按钮点击事件
     */
    public static class ButtonClickEvent implements UIEvent {
        public final String source;
        public final String buttonText;

        public ButtonClickEvent(String source, String buttonText) {
            this.source = source;
            this.buttonText = buttonText;
        }

        @Override
        public String toString() {
            return "ButtonClickEvent{" +
                    "source='" + source + '\'' +
                    ", buttonText='" + buttonText + '\'' +
                    '}';
        }
    }

    /**
     * 标签更新事件
     */
    public static class LabelUpdateRequestEvent implements UIEvent {
        public final String targetLabel;
        public final String newText;
        public final String source;

        public LabelUpdateRequestEvent(String targetLabel, String newText, String source) {
            this.targetLabel = targetLabel;
            this.newText = newText;
            this.source = source;
        }

        @Override
        public String toString() {
            return "LabelUpdateRequestEvent{" +
                    "targetLabel='" + targetLabel + '\'' +
                    ", newText='" + newText + '\'' +
                    ", source='" + source + '\'' +
                    '}';
        }
    }
}
