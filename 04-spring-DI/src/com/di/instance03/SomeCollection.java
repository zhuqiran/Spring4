package com.di.instance03;

import java.util.*;

/**
 * 为Bean的集合属性注入值
 */
public class SomeCollection {

    private School[] schools;
    private String[] names;

    private List<String> list;
    private Set<String> set;

    private Map<String, Object> map;
    private Properties properties;

    public void setSchools(School[] schools) {
        this.schools = schools;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "SomeCollection{" +
                "schools=" + Arrays.toString(schools) +
                ", names=" + Arrays.toString(names) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
