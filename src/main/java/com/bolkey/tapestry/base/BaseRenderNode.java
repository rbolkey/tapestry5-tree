package com.bolkey.tapestry.base;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.AfterRenderBody;
import org.apache.tapestry5.annotations.BeforeRenderBody;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.annotations.Parameter;
import com.bolkey.tapestry.model.Node;

public class BaseRenderNode {

    @Parameter(required = true, cache = false)
    private Node node;

    @Parameter
    private int childPosition;

    @SetupRender
    boolean setup() {
        // prevents rending with the node parameter is null.
        return node != null;
    }

    @BeforeRenderBody
    boolean beforeChild() {
        // the node  has children, render the body to render a child
        final boolean render = node.getChildren().size() > 0;

        if (render) {
            // sets the container's currentNode to the node's child at the given index.
            node = node.getChildren().get(childPosition);
        }
        return render;
    }

    @AfterRenderBody
    boolean afterChild() {
        // increment the child position, afterRender on the child will have the container's currentNode set back to the node before the body was rendered.
        childPosition = childPosition + 1;
        // return true on last child index, finishing the iteration over the children, otherwise re-render the body (to render the next child)
        return node.getChildren().size() <= childPosition;
    }

    @AfterRender
    void after() {
        // set the currentNode to the parent after render (pop the stack)
        if (!node.isRoot())
            node = node.getParent();
    }

    public Node getNode() {
        return node;
    }
}
