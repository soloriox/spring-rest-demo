package com.demo.spring.demo.entities;

public enum IsOfficial {

    T(true), F(false);

    private boolean value;

    IsOfficial(boolean value) {
        this.value = value;
    }

    public boolean getValue(){
        return this.value;
    }
}
