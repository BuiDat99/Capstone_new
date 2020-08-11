package com.capstone.utils;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

public class DuplicateParameterReducingPropertyEditor extends PropertyEditorSupport {

    Object value;

    @Override
    public void setValue(Object value) {
        if (value instanceof String[]) {
            String[] strings = (String[]) value;
            this.value = strings;
        } else {
            this.value = value;
        }
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        this.value = text;
    }

    @Override
    public String getAsText() {
        return value.toString();
    }

    @Override
    public Object getValue() {
        return value;
    }

};