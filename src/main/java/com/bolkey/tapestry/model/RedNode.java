package com.bolkey.tapestry.model;

public class RedNode extends BaseNode {

    public RedNode(final String name, final BaseNode... children) {
        super(name, children);
    }

    @Override
    public String toString() {
        return getName() + " (red)";
    }
}
