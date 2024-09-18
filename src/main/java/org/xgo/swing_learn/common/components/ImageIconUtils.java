package org.xgo.swing_learn.common.components;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义 图标组件
 */
public class ImageIconUtils {

    public static ImageIcon generator(String path, int width, int height) {
        // 创建原始 ImageIcon
        ImageIcon originalIcon = new ImageIcon(ImageIconUtils.class.getResource(path));
        // 调整图像大小
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

}
