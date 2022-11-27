package org.example.support;

import java.util.Comparator;

public class TestEventReverseComparator implements Comparator<TestEvent> {
    @Override
    public int compare(TestEvent o1, TestEvent o2) {
        return o2.getPriority().compareTo(o1.getPriority());
    }
}
