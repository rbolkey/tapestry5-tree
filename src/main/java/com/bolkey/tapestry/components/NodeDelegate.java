package com.bolkey.tapestry.components;

import org.apache.tapestry5.annotations.Parameter;

public class NodeDelegate {

    @Parameter(required = true, cache = false)
    private Object to;

    Object beginRender() {
        return to;
    }
}