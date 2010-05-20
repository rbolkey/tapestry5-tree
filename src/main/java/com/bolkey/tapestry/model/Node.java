package com.bolkey.tapestry.model;

import java.util.List;

public interface Node {

    /**
     * @return <code>true</code> if it's the root of the true, otherwise, false
     */
    boolean isRoot();

    /**
     * @return the parent of the node, or <code>null</code> if root of tree.
     */
    Node getParent();

    /**
     * Returns a list of the node's children.
     *
     * @return a list
     */
    List<Node> getChildren();
}
