package com.zhaoxi.edu.demo.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FuheInterfaceImpl implements FuheInterface {
    private List<String> lists;
    private Set<String> sets;
    private Map<String, String> maps;
    private Properties pros;

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }

    @Override
    public List<String> getLists() {
        return lists;
    }

    @Override
    public Set<String> getSets() {
        return sets;
    }

    @Override
    public Map<String, String> getMaps() {
        return maps;
    }

    @Override
    public Properties getPros() {
        return pros;
    }
}
