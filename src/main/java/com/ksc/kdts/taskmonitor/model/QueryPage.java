package com.ksc.kdts.taskmonitor.model;



public class QueryPage extends Page {
    public QueryPage() {
    }

    public QueryPage(Integer current, Integer size) {
        this.setCurrent(current == null ? 1L : (long)current);
        this.setSize(size == null ? 10L : (long)size);
    }
}
