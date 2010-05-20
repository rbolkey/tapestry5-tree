package com.bolkey.tapestry.model;

import org.apache.tapestry5.ioc.internal.util.CollectionFactory;

import java.util.List;

public class BaseNode implements Node {

    private Node parent;

    private final List<Node> children;
    private final String name;

    public BaseNode(final String name, final BaseNode... children) {

        this.name = name;
        this.parent = null;
        this.children = CollectionFactory.newList();

        for (final BaseNode child : children) {
            child.setParent(this);
            this.children.add(child);
        }
    }

    public boolean isRoot() {
        return parent == null;
    }

    public Node getParent() {
        return parent;
    }

    private void setParent(final Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }
}
