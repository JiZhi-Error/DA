package com.qq.taf.jce.dynamic;

public class StringField extends JceField {
    private String data;

    StringField(String str, int i2) {
        super(i2);
        this.data = str;
    }

    public String get() {
        return this.data;
    }

    public void set(String str) {
        this.data = str;
    }
}
