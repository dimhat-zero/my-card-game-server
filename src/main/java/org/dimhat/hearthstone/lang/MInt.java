package org.dimhat.hearthstone.lang;

/**
 * 数值类
 * 如攻击增加了多少，血量增加了多少
 * 影响：
 */
public class MInt {

    private int base;//基础值

    private int add;//永久加成值

    private int add2;//本回合加成值

    public MInt(int base) {
        this.base = base;
    }
}
