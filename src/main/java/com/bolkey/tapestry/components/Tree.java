package com.bolkey.tapestry.components;

import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;
import com.bolkey.tapestry.model.Node;
import com.bolkey.tapestry.model.BlackNode;
import com.bolkey.tapestry.model.RedNode;
import com.bolkey.tapestry.base.BaseRenderNode;

import java.util.Map;

public class Tree {

    @Parameter(required = true)
    private Node node;

    @Component(id = "blackNode", parameters = {"node=currentNode", "childPosition=currentChildPosition"})
    private RenderBlackNode blackNode;

    @Component(id = "redNode", parameters = {"node=currentNode", "childPosition=currentChildPosition"})
    private RenderRedNode redNode;

    private Node currentNode;

    private Map<Node, Integer> childPositions;

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(final Node node) {
        // set the initial child position for the node to 0 if it has not been seen yet.
        if (!childPositions.containsKey(node)) {
            childPositions.put(node, 0);
        }
        this.currentNode = node;
    }

    public int getCurrentChildPosition() {
        return childPositions.get(this.currentNode);
    }

    public void setCurrentChildPosition(final int pos) {
        this.childPositions.put(currentNode, pos);
    }

    /**
     * Selects the Node component to render based on the currentNode type.
     *
     * @return the component to render the current node
     */
    public BaseRenderNode getCurrentNodeRenderer() {
        BaseRenderNode object = null;
        if (currentNode instanceof BlackNode) {
            object = blackNode;
        }
        else if (currentNode instanceof RedNode) {
            object = redNode;
        }
        return object;
    }

    void setupRender() {
        childPositions = CollectionFactory.newMap();
        setCurrentNode(node);
    }
}
