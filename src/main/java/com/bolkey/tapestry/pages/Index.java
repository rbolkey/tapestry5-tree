package com.bolkey.tapestry.pages;

import com.bolkey.tapestry.components.Tree;
import com.bolkey.tapestry.model.BlackNode;
import com.bolkey.tapestry.model.Node;
import com.bolkey.tapestry.model.RedNode;
import org.apache.tapestry5.annotations.Component;

/**
 * Test page of application tapestry-tree.
 */
public class Index {

    @Component(parameters = "node=root")
    private Tree tree;

    private Node root;

    public Node getRoot() {
        return root;
    }

    void setupRender() {
        // (a (b (c )(d )) (e (f )))
        root = new RedNode("a", new BlackNode("b", new BlackNode("c"), new RedNode("d")),
                new RedNode("e", new BlackNode("f")));
    }
}
