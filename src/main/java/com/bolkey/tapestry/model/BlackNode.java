package com.bolkey.tapestry.model;

public class BlackNode extends BaseNode {

    public BlackNode(final String name, final BaseNode... children) {
        super(name, children);
    }

    @Override
    public String toString() {
        return getName() + " (black)";
    }
}
