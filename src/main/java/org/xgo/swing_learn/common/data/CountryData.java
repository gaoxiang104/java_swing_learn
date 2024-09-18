package org.xgo.swing_learn.common.data;

import java.util.HashMap;
import java.util.Map;

/**
 * 城市与首都 数据
 */
public class CountryData {
    // 创建一个 HashMap 实例
    public static Map<String, String> COUNTRY_CAPITAL_MAP = new HashMap<>();

    static {
        // 插入 10 条数据
        COUNTRY_CAPITAL_MAP.put("美国", "华盛顿特区");
        COUNTRY_CAPITAL_MAP.put("加拿大", "渥太华");
        COUNTRY_CAPITAL_MAP.put("英国", "伦敦");
        COUNTRY_CAPITAL_MAP.put("法国", "巴黎");
        COUNTRY_CAPITAL_MAP.put("德国", "柏林");
        COUNTRY_CAPITAL_MAP.put("日本", "东京");
        COUNTRY_CAPITAL_MAP.put("澳大利亚", "堪培拉");
        COUNTRY_CAPITAL_MAP.put("中国", "北京");
        COUNTRY_CAPITAL_MAP.put("印度", "新德里");
        COUNTRY_CAPITAL_MAP.put("巴西", "巴西利亚");
    }
}
