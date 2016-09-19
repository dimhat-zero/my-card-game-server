package org.dimhat.hearthstone.model.action;

/**
 * 一个动作指令
 */
public class Action {

    private String source;//发起动作源

    private String target;//目标

    /**
     * 动作种类：攻击，战吼
     */
    private ActionTypeEnum actionType;

}
