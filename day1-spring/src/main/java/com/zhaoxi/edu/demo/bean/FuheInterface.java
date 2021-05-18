package com.zhaoxi.edu.demo.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 复合类型的集合进行装配
 */
public interface FuheInterface {
    List<String> getLists();
    Set<String> getSets();
    Map<String, String> getMaps();
    Properties getPros();
}
