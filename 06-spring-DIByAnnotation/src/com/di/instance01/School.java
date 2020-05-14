package com.di.instance01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "school")
@Scope(value = "singleton")
public class School {
    @Value(value = "清华大学")
    private String schoolName;

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                '}';
    }
}
