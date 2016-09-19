package org.dimhat.hearthstone.model;

/**
 * 法力水晶
 * 没有设计过载
 */
public class Crystal {

    private int base;

    private int current;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
