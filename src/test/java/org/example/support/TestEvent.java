package org.example.support;

import lombok.Data;

@Data
public class TestEvent implements Comparable<TestEvent> {
    private final String name;
    private final Integer priority;


    @Override
    public int compareTo(TestEvent o) {
        return this.priority.compareTo(o.priority);
    }

}


